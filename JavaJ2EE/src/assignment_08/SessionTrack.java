package assignment_08;

/**
 * @author Anuj2.Kumar
 * 
 * Session Tracking Implementation
a) Study Http Session
b) Create a servlet as ‘HttpSession’ , use the HttpSession object to find out the creation time and the last-accessed time for a session
c) Display ‘Creation Time’ , ‘Time of Last Access’ and ‘Number of visits’
 */

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

//Extend HttpServlet class
@WebServlet("/HttpSession")
public class SessionTrack extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
      
   // Create a session object if it is already not  created.
   HttpSession session = request.getSession(true);
      
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
      
   // Get last access time of this web page.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String title = "Welcome Back to my website";
   Integer visitCount = new Integer(0);
   String visitCountKey = new String("visitCount");
   String userIDKey = new String("userID");
   String userID = new String("Anuj");

   // Check if this is new comer on your web page.
   if (session.isNew()) {
      title = "Welcome to my website";
      session.setAttribute(userIDKey, userID);
   } else {
      visitCount = (Integer)session.getAttribute(visitCountKey);
      visitCount = visitCount + 1;
      userID = (String)session.getAttribute(userIDKey);
   }
   session.setAttribute(visitCountKey,  visitCount);

   // Set response content type
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();

   out.println("-------------------\n");
   out.println("<p> Session ID : " + session.getId());
   out.println("<p> Creation Time : "+ createTime);
   out.println("<p> Last Access Time : "+ lastAccessTime);
   out.println("<p> User ID : " + userID);
   out.println("<p> No of visits : "+ visitCount);
   
   session.setMaxInactiveInterval(10);
   
 
	   }
	}