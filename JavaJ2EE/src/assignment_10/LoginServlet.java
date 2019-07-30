package assignment_10;

/**
 * @author Anuj2.Kumar
 * 
 * Servlet HttpSession Login and Logout Example.
a) Create a real world login and logout application with authentication from properties files b) In this example,
 we are creating 3 links: login, logout and profile. c) User can't go to profile page until he/she is logged in. d)
  If user is logged out, he need to login again to visit profile. e) In this application, we have created following files.
    index.html  login.html  LoginServlet.java  LogoutServlet.java  ProfileServlet.java
 */

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(password.equals("admin123")){  
        out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login_10.html").include(request, response);  
        }  
        out.close();  
    }  
}  