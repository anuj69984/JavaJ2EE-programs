package assignment_07;

/**
 * @author Anuj2.Kumar
 */

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Extend HttpServlet class
@WebServlet("/ViewCookie")
public class ReadCookies extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
   
   Cookie cookie = null;
   Cookie[] cookies = null;

   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();

   // Set response content type
   response.setContentType("text/html");

   PrintWriter out = response.getWriter();
   String title = "Reading Cookies Example";

   if( cookies != null ) {
      out.println("<h2> Found Cookies Name and Value</h2>");

      for (int i = 0; i < cookies.length; i++) {
         cookie = cookies[i];
         out.print("Name : " + cookie.getName( ) + ",  ");
         out.print("Value: " + cookie.getValue( ) + " <br/>");
      }
   } else {
      out.println("<h2>No cookies founds</h2>");
   }
   out.println("</body>");
   out.println("</html>");
}
}