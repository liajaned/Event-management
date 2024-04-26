package in.co.online.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.EventTypeBean;
import in.co.online.Model.EventTypeModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class EventTypeListCtl
 */
@WebServlet(name = "EventTypeListCtl", urlPatterns = "/eventlist")
public class EventTypeListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventTypeListCtl() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          long id = DataUtility.getlong(request.getParameter("id"));

          EventTypeModel model = new EventTypeModel();
          EventTypeBean bean = new EventTypeBean();
          List list = null;
          try {
		     list =	model.list();
		     ServletUtility.setList(list, request);
		     ServletUtility.forward(getView(), request, response);
		     
		} catch (Exception e) {

		}
          ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	@Override
	protected String getView() {

		return EM_View.EVENT_LIST_VIEW;
	}

}
