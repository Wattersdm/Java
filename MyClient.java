import java.io.*;  
import java.net.*;


/**
 * Abstract: Demonstrates how to make a socket displaying message to a single client. (Client part)
 * @author Devin Watters
 * @version 1.0
 */
public class MyClient {
	
	// ss.accept() method 
	
	// Socket is on the localhost port #5555.
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {    
			//create a stream socket and connect it to the specified port number at the specified IP address
			Socket s = new Socket("localhost", 5555);  
			//create dout DataOutputStream
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			//write text to dout
			dout.writeUTF("Hello Server from MyClient");  
			//force bytes to be written to the dout stream
			dout.flush();  
			//close stream
			dout.close(); 
			//close socket
			s.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
