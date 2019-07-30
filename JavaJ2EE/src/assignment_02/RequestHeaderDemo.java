package assignment_02;

/**
 * @author Anuj2.Kumar
 * 
 * Create a servlet (ServletRequestHeaderInfo)
a) Prints out the three components of the main request line (method, URI, and protocol).
b) Now creates a table of all the headers it receives, along with their associated values.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestHeaderServlet")
public class RequestHeaderDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)

	throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p><B> method name : </B>"+ request.getMethod()+ "\n");
		out.println("<p><B> Requested URI : </B>"+ request.getRequestURI()+"\n");
		out.println("<p><B>Request Protocol: </B>" + request.getProtocol()+"\n");
		out.println();
		
		//Enumeration means a list of named constant
		//An Enumeration can have constructors, methods and instance variables
		
		Enumeration<String> headerNames = request.getHeaderNames();
		out.println("Headers<hr/>");
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.print("Header Name: <em>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print("</em>, Header Value: <em>" + headerValue);
			out.println("</em><br/>");
		}
	}
}

