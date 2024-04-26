package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.PaymentBean;
import in.co.online.Bean.UserBean;
import in.co.online.Model.PaymentModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class PaymentCtl
 */
@WebServlet(name = "PaymentCtl", urlPatterns = "/payment")
public class PaymentCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_PAY = "Pay";

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidater.isNull(request.getParameter("personname"))) {
			request.setAttribute("personname", PropertyReader.getvalue("error.require", "personname"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("cardnumber"))) {
			request.setAttribute("cardnumber", PropertyReader.getvalue("error.require", "CardNumber"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("expire"))) {
			request.setAttribute("expire", PropertyReader.getvalue("error.require", "Expire"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("cvv"))) {
			request.setAttribute("cvv", PropertyReader.getvalue("error.require", "Cvv"));
			pass = false;
		}
		return pass;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		PaymentBean bean = new PaymentBean();
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setPersonname(DataUtility.getString(request.getParameter("personname")));
		bean.setCardnumber(DataUtility.getString(request.getParameter("cardnumber")));
		bean.setExpire(DataUtility.getString(request.getParameter("expire")));
		bean.setCvv(DataUtility.getString(request.getParameter("cvv")));
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

		System.out.println("in do post");
		long id = DataUtility.getlong(request.getParameter("id"));
		String op = DataUtility.getString(request.getParameter("operation"));
		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();
		if (OP_PAY.equalsIgnoreCase(op)) {
			bean = (PaymentBean) populateBean(request);
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("payment success", request);

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.PAYMENT_VIEW;
	}

}
