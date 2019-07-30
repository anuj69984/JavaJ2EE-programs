package assignment_13;

/**
 * @author Anuj2.Kumar
 * 
 * Design basis calculator using REST
a) Create a class (Client), which will take following input from user.
 firstNumber
 secondNumber
 operation
b) Client class will send 3 parameters in request headers.
c) Create a servlets (Server), which will accepts request send from above client and do the following
d) Get and parse the sent header
e) Get the operation
f) Process the results based on the operation
g) Sent an Response header a ‘result’ back to the client
h) Client class will get the response header and will print the results
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		float firstNumber=Float.parseFloat(req.getHeader("firstNumber"));
		float secondNumber=Float.parseFloat(req.getHeader("secondNumber"));
		String operationString=req.getHeader("operation");//.toLowerCase();
		float result=0;
		switch (operationString) {
		case "addition":
			result=firstNumber+secondNumber;
			break;
		case "subtraction":
			if(firstNumber>secondNumber)
				result=firstNumber-secondNumber;
			else
				result=secondNumber-firstNumber;
			break;
		case "multiplication":
			result=firstNumber*secondNumber;
			break;
		case "division":
			try
			{
				result=firstNumber/secondNumber;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:System.out.println("Wrong operation");
			break;
		}
		resp.getWriter().println("result "+result);
	}

}
