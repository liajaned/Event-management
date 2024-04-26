package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.UserBean;
import in.co.online.Model.UserModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class RegistrationCtl
 */
@WebServlet(name = "RegistrationCtl", urlPatterns = "/register")
public class RegistrationCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SUBMIT = "Submit";

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidater.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getvalue("error.require", "FirstName"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastname", PropertyReader.getvalue("error.require", "lastName"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
			pass = false;
		}
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getvalue("error.require", "Gender"));
			pass = false;
		}

		if ("-----Select-----".equalsIgnoreCase(request.getParameter("roleName"))) {
			request.setAttribute("roleName", PropertyReader.getvalue("error.require", "RoleName"));
			pass = false;
		}
		return pass;

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationCtl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected BaseBean populatebBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setRoleid(2);
        populateDto(bean, request);
        return bean;
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getlong(request.getParameter("id"));
		String op = DataUtility.getString(request.getParameter("operation"));
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
	      	bean =	(UserBean) populatebBean(request);
	      	try {
				long pk =  model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Registration Complete", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
	      	
		}
	ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.REGISTRATION__VIEW;
	}

}
