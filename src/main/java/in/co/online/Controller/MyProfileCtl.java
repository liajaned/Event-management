package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.RoleBean;
import in.co.online.Bean.UserBean;
import in.co.online.Model.UserModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class MyProfileCtl
 */
@WebServlet(name = "MyProfileCtl" ,urlPatterns = "/myprofile")
public class MyProfileCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_UPDATE = "Update";
	public static final String OP_MYPROFILE = "Myprofile";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileCtl() {
        super();
        // TODO Auto-generated constructor stub
    }
	/*
	 * protected boolean validate(HttpServletRequest request) { boolean pass = true;
	 * if (DataValidater.isNull(request.getParameter("firstName"))) {
	 * request.setAttribute("firstName", PropertyReader.getvalue("error.require",
	 * "FirstName")); pass = false; } if
	 * (DataValidater.isNull(request.getParameter("lastName"))) {
	 * request.setAttribute("lastname", PropertyReader.getvalue("error.require",
	 * "lastName")); pass = false; } if
	 * (DataValidater.isNull(request.getParameter("email"))) {
	 * request.setAttribute("email", PropertyReader.getvalue("error.require",
	 * "Email")); pass = false; } if
	 * (DataValidater.isNull(request.getParameter("password"))) {
	 * request.setAttribute("password", PropertyReader.getvalue("error.require",
	 * "Password")); pass = false; } if
	 * ("-----Select-----".equalsIgnoreCase(request.getParameter("gender"))) {
	 * request.setAttribute("gender", PropertyReader.getvalue("error.require",
	 * "Gender")); pass = false; }
	 * 
	 * if ("-----Select-----".equalsIgnoreCase(request.getParameter("roleName"))) {
	 * request.setAttribute("roleName", PropertyReader.getvalue("error.require",
	 * "RoleName")); pass = false; } return pass;
	 * 
	 * }
	 */


    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession(true);

	        UserBean UserBean = (UserBean) session.getAttribute("user");
	        long id = UserBean.getId();
	        String op = DataUtility.getString(request.getParameter("operation"));

	        // get model
	        UserModel model = new UserModel();
	        if (id > 0 || op != null) {
	            System.out.println("in id > 0  condition");
	            UserBean bean;
	            try {
	                bean = model.findByPK(id);
	                ServletUtility.setbean(bean, request);
	            } catch (Exception e) {          //ApplicationException
	                ServletUtility.handleException(e, request, response);
	                return;
	            }
	        }
	       
	        ServletUtility.forward(getView(), request, response);

	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		UserBean UserBean = (UserBean) session.getAttribute("user");
		long id = UserBean.getId();
		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel model = new UserModel();
		if (OP_UPDATE.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				if (id > 0) {
					UserBean.setFirstName(bean.getFirstName());
					UserBean.setLastName(bean.getLastName());
					
					UserBean.setGender(bean.getGender());
					model.Update(UserBean);
					ServletUtility.setbean(bean, request);
					ServletUtility.setSuccessMessage("Profile has been updated Successfully. ", request);
					ServletUtility.forward(getView(), request, response);

				}
			} catch (Exception e) { // ApplicationException
				ServletUtility.handleException(e, request, response);
				return;
			}
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.MYPROFILE_VIEW;
	}

}
