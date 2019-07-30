package com.anuj;
/**
 * @author Anuj2.Kumar
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int a=Integer.parseInt(req.getParameter("input1"));
		int b=Integer.parseInt(req.getParameter("input2"));
		
		int c=a+b;
		res.getWriter().println(c);
		
		PrintWriter out=res.getWriter();
		out.println();
		//System.out.println(c);
	}
}