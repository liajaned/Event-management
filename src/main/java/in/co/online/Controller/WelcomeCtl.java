package in.co.online.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.online.Utility.ServletUtility;

/**
 * Servlet implementation class WelcomeCtl
 */
@WebServlet(name = "WelcomeCtl" ,urlPatterns = "/welcome")
public class WelcomeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	
	protected String getView(){
		return EM_View.WELCOME_VIEW;
	}

}
