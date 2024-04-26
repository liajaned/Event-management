package in.co.online.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Utility.JDBCDataSource;

/**
 * Servlet implementation class ImageCtl
 */
@WebServlet(name = "ImageCtl", urlPatterns = "/image")
public class ImageCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn;
		try {
			conn = JDBCDataSource.getconnection();
			String sql = "SELECT * FROM venue WHERE ID='" + id + "'";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				byte[] imageData = rs.getBytes("image");
			    OutputStream os =	response.getOutputStream();
			    os.write(imageData);
			    os.flush();
			    os.close();
			}
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected String getView() {
		return null;
	}

}
