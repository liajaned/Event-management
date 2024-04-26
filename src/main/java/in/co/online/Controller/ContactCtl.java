package in.co.online.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.ContactBean;
import in.co.online.Exception.ApplicationException;
import in.co.online.Exception.DuplicateRecordException;
import in.co.online.Model.ContactModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class ContactCtl
 */
@WebServlet(name = "ContactCtl" ,urlPatterns = "/contact")

public class ContactCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
	public static final String OP_SEND= "send";

	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validation");

		boolean pass = true;

		if (DataValidater.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getvalue("error.require", "Name"));
			pass = false;

		} 
		if (DataValidater.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email"));
			pass = false;

		} 
		if (DataValidater.isNull(request.getParameter("subject"))) {
			request.setAttribute("subject", PropertyReader.getvalue("error.require", "Subject"));
			pass = false;

		} 
		if (DataValidater.isNull(request.getParameter("message"))) {
			request.setAttribute("message", PropertyReader.getvalue("error.require", "Message"));
			pass = false;
		} 
		return pass;
	}

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected BaseBean populateBean(HttpServletRequest request) {
    	System.out.println("in populateBean");
		ContactBean bean = new ContactBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setSubject(DataUtility.getString(request.getParameter("subject")));
		bean.setMessage(DataUtility.getString(request.getParameter("message")));
		populateDto(bean, request);
		return bean;

	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ContactModel model = new ContactModel();
        System.out.println("in do post");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getlong(request.getParameter("id"));
		ContactBean bean = new ContactBean();

			if (OP_SEND.equalsIgnoreCase(op)) {
				bean = (ContactBean) populateBean(request);
				try {
					long pk = model.add(bean);
					ServletUtility.setbean(bean, request);
					ServletUtility.setSuccessMessage("Contact Submit", request);
					ServletUtility.forward(getView(), request, response);
					return;
				} catch (DuplicateRecordException e) {
					ServletUtility.setbean(bean, request);
					ServletUtility.setErrorMessage(e.getMessage(), request);
					ServletUtility.forward(getView(), request, response);

				} catch (ApplicationException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}
				ServletUtility.forward(getView(), request, response);

			}
	}
	@Override
	protected String getView() {
		return EM_View.CONTACT_VIEW;
	}
}
