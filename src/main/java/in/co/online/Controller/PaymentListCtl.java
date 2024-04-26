package in.co.online.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.PaymentBean;
import in.co.online.Bean.UserBean;
import in.co.online.Bean.VenueBean;
import in.co.online.Model.PaymentModel;
import in.co.online.Model.VenueModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class PaymentListCtl
 */
@WebServlet(name = "PaymentListCtl", urlPatterns = "/paymentlist")
public class PaymentListCtl extends BaseCtl {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentListCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
    	PaymentBean bean = new PaymentBean();
    	HttpSession session = request.getSession(false);
		UserBean bean2 = (UserBean) session.getAttribute("user");
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		System.out.println(request.getParameter("personname"));
		bean.setPersonname(DataUtility.getString(request.getParameter("personname")));
		bean.setCardnumber(DataUtility.getString(request.getParameter("cardnumber")));
		bean.setExpire(DataUtility.getString(request.getParameter("expire")));
		bean.setCvv(DataUtility.getString(request.getParameter("cvv")));
		
		return populateDto(bean, request);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PaymentModel model = new PaymentModel();
        PaymentBean bean = new PaymentBean();
        List list = null;
        HttpSession session = request.getSession(false);
    	UserBean bean2 = (UserBean) session.getAttribute("user");
    	long roleid = bean2.getRoleid();
    	if (roleid==2) {
    		   try {
    			     list =	model.showPayment(bean2.getId());
    			     ServletUtility.setList(list, request);
    			     
    			} catch (Exception e) {
    			}
		}else{
			 try {
			     list =	model.list();
			     ServletUtility.setList(list, request);
			     
			} catch (Exception e) {
			
		}
		
		}
        ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	protected String getView() {
		return EM_View.PAYMENT_LIST_VIEW;
	}

}
