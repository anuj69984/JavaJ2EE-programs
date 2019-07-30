package assignment_12;

/**
 * @author Anuj2.Kumar
 * 
 * Study and Implementation of REST
a) Create an example for demonstrating REST method calls
b) Take Input from user which method (GET/POST/PUT/DELETE)he/ she wants to call
c) Take username as input
d) Based on the input provided , call the appropriate method & set username in request header
e) Create a servlet to serve these methods
f) Retrieve username in each method & print the same
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.jio.resttalk.service.custom.exceptions.RestTalkInvalidURLException;
import com.jio.resttalk.service.custom.exceptions.RestTalkServerConnectivityError;
import com.jio.resttalk.service.impl.RestTalkBuilder;
import com.jio.resttalk.service.response.RestTalkResponse;

public class RestTalkDemo {

	public static void main(String[] args) throws UnknownHostException, RestTalkInvalidURLException, RestTalkServerConnectivityError {
		Scanner scanner=new Scanner(System.in);
		System.out.println("please Enter Method name");
		String method=scanner.nextLine().trim().toUpperCase();
		
		System.out.println("please Enter username");
		String username=scanner.nextLine().trim();
		
		InetAddress inetAddress=InetAddress.getLocalHost();
		String ipAddress=inetAddress.getHostAddress();
		
		RestTalkResponse restTalkResponse=null;
		String url="http://"+ipAddress+":8091/rest";
		
		String response=null;
		switch(method) {
		case "GET":
			restTalkResponse=new RestTalkBuilder().Get(url).addCustomHeader("username",username).send();
			response=restTalkResponse.answeredContent().responseString();
			break;
		case "POST":
			restTalkResponse=new RestTalkBuilder().Post(url).addCustomHeader("username",username).send();
			response=restTalkResponse.answeredContent().responseString();
			break;
		case "PUT":
			restTalkResponse=new RestTalkBuilder().Put(url).addCustomHeader("username",username).send();
			response=restTalkResponse.answeredContent().responseString();
			break;
		case "DELETE": 
			restTalkResponse=new RestTalkBuilder().Get(url).addCustomHeader("username",username).send();
			response=restTalkResponse.answeredContent().responseString();
			break;
			
		}
		System.out.println("From Server-> "+response);
		scanner.close();

	}

}
