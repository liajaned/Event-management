package in.co.online.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.UserBean;
import in.co.online.Model.UserModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class UserListCtl
 */
@WebServlet(name = "UserListCtl" ,urlPatterns = "/userlist")
public class UserListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListCtl() {
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
		bean.setRoleid(DataUtility.getlong(request.getParameter("rolename")));
        populateDto(bean, request);
        return bean;
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		long id = DataUtility.getlong(request.getParameter("id"));
		if (id>0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("User Data Deleted", request);
		}
		List list = null;
		try {
		
		list = model.list();
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {

		}
		if (list==null && list.size()==0) {
			ServletUtility.setErrorMessage("No Record Found", request);
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected String getView() {
		return EM_View.USERLIST_VIEW;
	}

}
