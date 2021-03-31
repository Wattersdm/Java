
import java.net.*;


/**
 * Abstract: Demonstrates how to use InetAddress in Java.
 * @author Devin Watters
 * @version 1.0
 */
public class HWNetworkGetNames {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			// 1) get the local host name and display it on the screen
			InetAddress localhost;
			localhost = InetAddress.getLocalHost();
			System.out.println("Your system is: " + localhost);
			
			// 2) using www.cincinnatistate.edu change the host name to its specific IP address with the help of InetAddress.getByName() method of net.InetAddress class.
			InetAddress address1 = InetAddress.getByName("www.cincinnatistate.edu");
			System.out.println("IP Address for www.cincinnatistate.edu");
			System.out.println(address1.getHostAddress());			
			
			// 3) list all addresses for www.google.com
			InetAddress[] google = InetAddress.getAllByName("google.com");
			System.out.println("Google's host address list:");
			for (InetAddress addr : google) {
			    System.out.println(addr.getHostAddress());
			}
			// 4) find the IP address of your favorite domain and display this on the screen.
			InetAddress address2 = InetAddress.getByName("www.github.com");
			System.out.println("My favorite IP Address for www.github.com");
			System.out.println(address2.getHostAddress());
			// 
		} catch (Exception e) {e.printStackTrace();
		}
	}
}
