package in.co.online.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import in.co.online.Bean.BaseBean;
import in.co.online.Bean.EventTypeBean;
import in.co.online.Bean.UserBean;
import in.co.online.Bean.VenueBean;
import in.co.online.Model.EventTypeModel;
import in.co.online.Model.UserModel;
import in.co.online.Model.VenueModel;
import in.co.online.Utility.DataUtility;
import in.co.online.Utility.DataValidater;
import in.co.online.Utility.PropertyReader;
import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class VenueCtl
 */
@WebServlet(name = "VenueCtl", urlPatterns = "/venue")
@MultipartConfig(maxFileSize = 16177215)
public class VenueCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SUBMIT = "Submit";


	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidater.isNull(request.getParameter("eventtypeid"))) {
			request.setAttribute("eventtypeid", PropertyReader.getvalue("error.require", "EventTypeid"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getvalue("error.require", "Location"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("capacity"))) {
			request.setAttribute("capacity", PropertyReader.getvalue("error.require", "Capacity"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("cost"))) {
			request.setAttribute("cost", PropertyReader.getvalue("error.require", "Cost"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("date"))) {
			request.setAttribute("date", PropertyReader.getvalue("error.require", "Date"));
			pass = false;
		}
		if (DataValidater.isNull(request.getParameter("contact"))) {
			request.setAttribute("contact", PropertyReader.getvalue("error.require", "Contact"));
			pass = false;
		}
		return pass;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VenueCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected BaseBean populateBean(HttpServletRequest request){
		VenueBean bean = new VenueBean();
		bean.setId(DataUtility.getlong(request.getParameter("id")));
		bean.setEventtypeid(DataUtility.getlong(request.getParameter("eventtypeid")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setCapacity(DataUtility.getString(request.getParameter("capacity")));
		bean.setCost(DataUtility.getString(request.getParameter("cost")));
		bean.setDate(DataUtility.getDate(request.getParameter("date")));
		bean.setContact(DataUtility.getString(request.getParameter("contact")));
		System.out.println("cost:"+bean.getCost());
		System.out.println("cost1:"+bean.getDate());
		System.out.println("cost2:"+bean.getCapacity());
		System.out.println("cost3:"+bean.getContact());
		System.out.println("cost4:"+bean.getEventtypeid());
		Blob blob = null;
		Part filepart;
		try {
			filepart =  request.getPart("image");
			blob = medicinePacketUpload(filepart);
		} catch (Exception e) {

		}
		bean.setImage(blob);
		System.out.println("cost6:"+bean.getImage());
		populateDto(bean, request);
		return bean;
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
		VenueModel model = new VenueModel();
		  VenueBean bean = new VenueBean();
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
	      	bean =	(VenueBean) populateBean(request);
	      	try {
				long pk =  model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Venue ADD Successfully", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
	      	
		}
		System.out.println("forword");
	ServletUtility.forward(getView(), request, response);
	}
	
	@Override
	protected String getView(){
		return EM_View.VENUE_VIEW;
	}

}
