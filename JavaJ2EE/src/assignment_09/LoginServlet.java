package assignment_09;

/**
 * @author Anuj2.Kumar
 * 
 * Request Dispatcher interface Implementation
a) Create an HTML form as ‘Login .html’ having following controls
 Username field
 Password filed
 Submit button
b) Create an properties file having two fields as
 Username=’username’
 Password =’Password’
c) Call a servlet (LoginServlet), which will accept username & password d) If the entered username & password matches
 with properties files, it will forward the request to the welcome servlet for displaying the welcome message e)
  If the entered username & password doesn’t matches with properties files, it will show an error message:
   sorry username or password error! On Login page
 */

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
  
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    String p=request.getParameter("userPass");  
          
    if(p.equals("LoginServlet")){  
        RequestDispatcher rd=request.getRequestDispatcher("Welcome");  
        rd.forward(request, response);  
    }  
    else{  
        out.print("Sorry UserName or Password Error!");  
        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);  
                      
        }  
    }  
  
}  