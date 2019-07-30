package assignment_03;
/**
 * @author Anuj2.Kumar
 * 
 * HTTP Header Response Example
a) Create a servlet that will display the digital clock. (Use setIntHeader () method to set Refresh header)
b) Output format: Current Time is: 9:44:50 PM
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/refreshServlet")
public class Refresh extends HttpServlet {

 private static final long serialVersionUID = 1L;

 /***** This Method Is Called By The Servlet Container To Process A 'GET' Request *****/
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     handleRequest(request, response);
 }

 public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

     /***** Set Refresh - AutoLoad Time as 15 Seconds *****/
     response.setIntHeader("Refresh", 15);

     /***** Set Response Content Type *****/
     response.setContentType("text/html");

     /***** Get Current Time *****/
     Calendar cal = new GregorianCalendar();
     String am_pm;
     int hour = cal.get(Calendar.HOUR);
     int minute = cal.get(Calendar.MINUTE);
     int second = cal.get(Calendar.SECOND);

     if(cal.get(Calendar.AM_PM) == 0)
         am_pm = "A.M.";
     else
         am_pm = "P.M.";

     String time = hour+":"+ minute +":"+ second +" "+ am_pm;

     /***** Print The Response *****/
     PrintWriter out = response.getWriter();
     String title = "Auto Refresh Header Setting";
     String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
     out.println(docType +
             "<html>\n" +
             "<head><title>" + title + "</title></head>\n"+
             "<body bgcolor = \"#f0f0f0\">\n" +
             "<h1 align = \"center\">" + title + "</h1>\n" +
             "<p>Current Time Is = " + time + "</p>\n");
 }
}
