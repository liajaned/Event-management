package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.RoleBean;
import in.co.online.Model.UserModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class RoleCtl
 */
@WebServlet(name = "RoleCtl", urlPatterns = "/role")
public class RoleCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SAVE = "Save";

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidater.isNull(request.getParameter("rolename"))) {
			request.setAttribute("rolename", PropertyReader.getvalue("error.require", "rolename"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "password"));
			pass = false;

		}
		return pass;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		RoleBean bean = new RoleBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setRolename(DataUtility.getString(request.getParameter("rolename")));
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
		RoleBean bean = new RoleBean();
		if (OP_SAVE.equalsIgnoreCase(op)) {
			bean = (RoleBean) populateBean(request);
			try {
				long pk = model.Roleadd(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Role successfully ADD", request);

			} catch (Exception e) {
			}
		}
		System.out.println("do post");
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.ROLE_VIEW;
	}

}
