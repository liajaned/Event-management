package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.EventTypeBean;
import in.co.online.Model.EventTypeModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class EventTypeCtl
 */
@WebServlet(name = "EventTypeCtl", urlPatterns = "/eventtype")
public class EventTypeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SUBMIT = "Submit";

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidater.isNull(request.getParameter("eventname"))) {
			request.setAttribute("eventname", PropertyReader.getvalue("error.require", "Event Name"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getvalue("error.require", "Description"));
			pass = false;
		}
		return pass;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EventTypeCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		EventTypeBean bean = new EventTypeBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setEventname(DataUtility.getString(request.getParameter("eventname")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
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
		EventTypeModel model = new EventTypeModel();
		EventTypeBean bean = new EventTypeBean();
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
			bean = (EventTypeBean) populateBean(request);
			try {
				long i = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Event Type ADD", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return EM_View.EVENT_TYPE_VIEW;
	}

}
