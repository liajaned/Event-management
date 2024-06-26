package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.UserBean;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class BaseCtl
 */
public abstract class BaseCtl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String OP_SEND= "send";
	public static final String OP_CANCEL = "cancel";
	public static final String OP_DELETE = "delete";
	public static final String OP_LIST = "List";
	public static final String OP_VIEW = "view";
	public static final String OP_SEARCH = "search";
	public static final String OP_NEW = "New";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "previous";
	public static final String OP_GO = "go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOGOUT = "Logout";
	public static final String OP_RESET = "Reset";
	public static final String OP_UPDATE = "update";
	public static final String OP_SUBMIT = "Submit";
	
	
	public static final String MSG_ERROR = "error";

	public static final String MSG_SUCCESS = "success";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseCtl() {
        super();
       
    }
    protected boolean validate(HttpServletRequest request){
		return true;
	}

	protected void preload(HttpServletRequest request) {

	}

	protected BaseBean populateBean(HttpServletRequest request){
		return null;
	}

	public BaseBean populateDto(BaseBean bean,HttpServletRequest request) {
		String createdby = request.getParameter("createdby");
		String modifiedby = null;
	      UserBean userbean = 	(UserBean) request.getSession().getAttribute("user");
		if (userbean == null) {
			createdby	= "root";
			modifiedby = "root";
		} else {

			if ("null".equals(createdby) || DataValidater.isNull(createdby)) {
				createdby = modifiedby;
			}
		}
		bean.setCreatedby(createdby);
		bean.setModifiedby(modifiedby);
		
		long cdt = DataUtility.getlong(request.getParameter("createdDatetime"));
		if (cdt>0L) {
			bean.setCreateddatetime(DataUtility.getTimestamp(cdt));
		} else {
			bean.setCreateddatetime(DataUtility.getCurrentTimestamp());
		}
		bean.setModifieddatetime(DataUtility.getCurrentTimestamp());
		return bean;
	}
	
	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		
		if (DataValidater.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op)
				&& !OP_RESET.equalsIgnoreCase(op) && !OP_DELETE.equalsIgnoreCase(op)
				&& !OP_VIEW.equalsIgnoreCase(op)){
			if (!validate(request)) {
			BaseBean bean = (BaseBean)populateBean(request);
			ServletUtility.setbean(bean, request);
			ServletUtility.forward(getView(), request, response);
			return;
			}
		}
		super.service(request, response);
	}
	
	protected abstract String getView();
}
