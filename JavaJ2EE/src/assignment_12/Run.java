package assignment_12;

/**
 * @author Anuj2.Kumar
 */
import java.net.InetAddress;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class Run {

	public static void main(String[] args) {
		ServerConnector connector = null;
		Server server = null;
		try {
		server = new Server();
		connector = new ServerConnector(server);
		InetAddress inetAddress = InetAddress.getLocalHost();
		String IP = inetAddress.getHostAddress();
		connector.setHost(IP);
		System.out.println(IP);
		connector.setPort(8091);
		
		server.setConnectors(new Connector[] {connector});
		
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		 
		ServletContextHandler hddInfo_Context1=new ServletContextHandler();
		hddInfo_Context1.setContextPath("/rest");
		hddInfo_Context1.addServlet(Servlet11.class, "");
		hddInfo_Context1.setAllowNullPathInfo(true);
		contexts.addHandler(hddInfo_Context1);

		
		HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[] { contexts, new DefaultHandler() });

		server.setHandler(handlers);

			server.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			System.err.println(server.isRunning());
			if(connector!=null ) {
				System.out.println("closing connection");
				
			}
			System.out.println("closed "+server.isRunning());
				

	}

	}

}
