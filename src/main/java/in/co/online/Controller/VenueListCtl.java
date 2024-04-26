package in.co.online.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.VenueBean;
import in.co.online.Model.VenueModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class VenueListCtl
 */
@WebServlet(name = "VenueListCtl" ,urlPatterns = "/venuelist")
public class VenueListCtl extends BaseCtl {


	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueListCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		VenueBean bean = new VenueBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setEventtypeid(DataUtility.getlong(request.getParameter("eventtypeid")));
	//	bean.setEventtype(DataUtility.getString(request.getParameter("eventtypeid")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setCapacity(DataUtility.getString(request.getParameter("capacity")));
		bean.setCost(DataUtility.getString(request.getParameter("cost")));
		bean.setDate(DataUtility.getDate(request.getParameter("date")));
		bean.setContact(DataUtility.getString(request.getParameter("contact")));
		Blob blob = null;
		Part filepart;
		try {
			filepart =  request.getPart("image");
			blob = medicinePacketUpload(filepart);
		} catch (Exception e) {

		}
		bean.setImage(blob);
		System.out.println("cost:"+bean.getCost());
		System.out.println("cost1:"+bean.getDate());
		System.out.println("cost2:"+bean.getCapacity());
		System.out.println("cost3:"+bean.getContact());
		System.out.println("cost4:"+bean.getEventtypeid());
		System.out.println("cost5:"+bean.getLocation());
		System.out.println("cost6:"+bean.getImage());
		return populateBean(request);
	}
    
	public Blob medicinePacketUpload(Part part) throws IOException {
		System.out.println("this si part :" + part);
		InputStream inputStream = null;
		Blob blob = null;
		inputStream =  part.getInputStream();
		byte[] b = new byte[inputStream.available()];
		inputStream.read(b);
		try {
			blob = new SerialBlob(b);
			
		} catch (Exception e) {
		}
		
		return blob;	
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

	}

	@Override
	protected String getView() {

		return EM_View.VENUE_LIST_VIEW;
	}

}
