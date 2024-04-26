package in.co.online.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Bean.VenueBean;
import in.co.online.Model.VenueModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class BookingCtl
 */
@WebServlet(name = "BookingCtl", urlPatterns = "/booking")
public class BookingCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = DataUtility.getlong(request.getParameter("id"));

        VenueModel model = new VenueModel();
        VenueBean bean = new VenueBean();
        List list = null;
        try {
		     list =	model.list();
		     ServletUtility.setList(list, request);
		     
		} catch (Exception e) {

		}
	ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected String getView() {
		return EM_View.BOOKING_VIEW;
	}

}
