package assignment_12;
/**
 * @author Anuj2.Kumar
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet11 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Servlet11() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("GET username: "+req.getHeader("username"));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("POST username: "+req.getHeader("username"));
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("PUT username: "+req.getHeader("username"));
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("DELETE username: "+req.getHeader("username"));
	}

}
