import java.io.*;  
import java.net.*;


/**
 * Abstract: Demonstrates how to make a socket displaying message to a single client. (Server part)
 * @author Devin Watters
 * @version 1.0
 */
public class MyServer {
	// the Socket is on the localhost port # 5555.
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try { 
			//create a server socket bound to port 5555
			ServerSocket ss = new ServerSocket(5555);  
			//listens for a connection to be made to this socket and accepts it
			Socket s = ss.accept();
			//create DataInputStream dis by getting the socket input 
			DataInputStream dis = new DataInputStream(s.getInputStream());  
			//return string of characters decoded from Unicode UTF-8 format
			String  str = (String)dis.readUTF();  
			//print message received from socket
			System.out.println("MyServer received this: " + str);  
			//close the server socket
			ss.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
}
