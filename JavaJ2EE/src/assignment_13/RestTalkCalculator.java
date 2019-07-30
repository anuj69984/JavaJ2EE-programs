package assignment_13;

/**
 * @author Anuj2.Kumar
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.jio.resttalk.service.custom.exceptions.RestTalkInvalidURLException;
import com.jio.resttalk.service.custom.exceptions.RestTalkServerConnectivityError;
import com.jio.resttalk.service.impl.RestTalkBuilder;
import com.jio.resttalk.service.response.RestTalkResponse;

public class RestTalkCalculator {

	public static void main(String[] args) throws UnknownHostException, RestTalkInvalidURLException, RestTalkServerConnectivityError {
		Scanner scanner=new Scanner(System.in);
		Scanner scan1=new Scanner(System.in);
		System.out.println("Enter First number: ");
		float firstNumber=scanner.nextFloat();
		
		System.out.println("Enter second number: ");
		float secondNumber=scanner.nextFloat();
		System.out.println("******** operation **************");
		System.out.println("Enter 'addition' to add ");
		System.out.println("Enter 'subtraction' to subtract ");
		System.out.println("Enter 'division' to divide ");
		System.out.println("Enter 'multiplication' to multiply ");
		System.out.println("--------------------------------");
		
		System.out.println("Enter operation ");
		String operation=scan1.nextLine();
		
		
		
		InetAddress inetAddress=InetAddress.getLocalHost();
		String ipAddress=inetAddress.getHostAddress();
		
		RestTalkResponse restTalkResponse=null;
		String url="http://"+ipAddress+":8091/calculator";
		
		String response=null;
		restTalkResponse=new RestTalkBuilder()
				.Get(url)
				.addCustomHeader("firstNumber",firstNumber+"")
				.addCustomHeader("secondNumber",secondNumber+"")
				.addCustomHeader("operation",operation+"")
				.send();
		//System.out.println("---------");
		response=restTalkResponse.answeredContent().responseString();
		System.out.println("From Server-> "+response);
		//System.out.println("********");
		scanner.close();
		scan1.close();

	}

}
