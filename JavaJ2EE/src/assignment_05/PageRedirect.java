package assignment_05;

/**
 * @author Anuj2.Kumar
 * 
 * Servlets - Page Redirection
a) Create a servlet as servlet Redirect which will redirect / send the client to new location(Say google.com)
 */

import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {
    
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");

      // New location to be redirected
      String site = new String("http://www.facebook.com");

      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site);    
   }
} 