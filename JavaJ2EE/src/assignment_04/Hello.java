package assignment_04;
/**
 * @author Anuj2.Kumar
 * 
 * Create an HTML form as ‘Login .html’ having following controls
a) Username field
b) Password filed
c) Submit button
Call a servlet (LoginServlet), which will accept & parse the username
Display the output as Welcome ‘username’
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		out.println("Welcome " + session.getAttribute("user"));
	}
}
