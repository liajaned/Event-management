package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.mysql.cj.Session;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.RoleBean;
import in.co.online.Bean.UserBean;
import in.co.online.Model.UserModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class LoginCtl
 */
@WebServlet(name = "LoginCtl", urlPatterns = "/login")
public class LoginCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SINGIN = "SignIn";
	public static final String OP_SING_UP = "SignUp";
	public static final String OP_LOGOUT = "Logout";

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (OP_SING_UP.equalsIgnoreCase(op) || OP_LOGOUT.equalsIgnoreCase(op)) {
			return true;
		}
		if (DataValidater.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email"));
			pass = false;
		} else if (!DataValidater.isEmail(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.login", "Email"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
			pass = false;
		} else if (!DataValidater.isPassword(request.getParameter("password"))) {
			request.setAttribute("error.password", "Password");
			pass = false;
		}
		return pass;

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		populateDto(bean, request);
		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		HttpSession session = request.getSession(false);
		UserBean bean = (UserBean) populateBean(request);
		if (OP_LOGOUT.equalsIgnoreCase(op)) {
			session = request.getSession(false);
			session.invalidate();
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Logout Succesfully", request);
			ServletUtility.forward(getView(), request, response);
			return;
		}
		ServletUtility.setbean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		long id = DataUtility.getlong(request.getParameter("id"));
		String op = DataUtility.getString(request.getParameter("operation"));
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		if (OP_SINGIN.equalsIgnoreCase(op)) {
			bean = (UserBean) populateBean(request);
			try {
				bean = model.Authenticate(bean.getEmail(), bean.getPassword());
				if (bean != null) {
					long rollid = bean.getRoleid();
					RoleBean rolebean = model.RolefindByPK(rollid);
					if (rolebean != null) {
						session.setAttribute("role", rolebean.getRolename());
						session.setAttribute("user", bean);
						ServletUtility.setbean(bean, request);
						ServletUtility.redirect(EM_View.WELCOME_CTL, request, response);
						return;
					} else {
						bean = (UserBean) populateBean(request);
						ServletUtility.setbean(bean, request);
						ServletUtility.setErrorMessage("Invalid Id and Password", request);
						ServletUtility.forward(getView(), request, response);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.LOGIN_VIEW;
	}

}
