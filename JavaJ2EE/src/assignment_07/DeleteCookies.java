package assignment_07;

/**
 * @author Anuj2.Kumar
 * 
 * Servlet Cookies Methods Implementation
a) Create an HTML form as ‘AddCookie .html’ having controls as First Name ,Last Name and submit button ,Try to enter First Name and Last Name and then click submit button. This would display first name and last name on your screen and same time it would set two cookies firstName and lastName
b) Create an HTML form as ‘ViewCookie .html’ having ‘View Cookie’ button. Create a servlet (ReadCookies) that would access these cookies back and print in your web application.
c) Create an HTML form as ‘DeleteCookie .html’ having ‘Delete Cookie’ button Create a servlet (DeleteCookies) that would access these cookies back and delete them.
 */

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Extend HttpServlet class
@WebServlet("/DeleteCookie")
public class DeleteCookies extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
   
   Cookie cookie = null;
   Cookie[] cookies = null;
      
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();

   // Set response content type
   response.setContentType("text/html");

   PrintWriter out = response.getWriter();
   String title = "Delete Cookies Example";
    
   if( cookies != null ) {
      out.println("<h2> Cookies Name and Value</h2>");

      for (int i = 0; i < cookies.length; i++) {
         cookie = cookies[i];
         

         if((cookie.getName( )).compareTo("first_name") == 0 ) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            out.print("Deleted cookie : " + cookie.getName( ) + "<br/>");
         }
         out.print("Name : " + cookie.getName( ) + ",  ");
         out.print("Value: " + cookie.getValue( )+" <br/>");
      }
   } else {
      out.println("<h2>No cookies founds</h2>");
   }
   out.println("</body>");
   out.println("</html>");
}
}