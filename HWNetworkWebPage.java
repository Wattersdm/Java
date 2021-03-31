
import java.net.*;
import java.io.*;


/**
 * Abstract: Demonstrates how to read and download a webpage.
 * @author Devin Watters
 * @version 1.2
 */
public class HWNetworkWebPage {

	/**
	 * Abstract: gets a web URL hostname from user
	 * @return url string from user
	 */
	public static String getURLName() {
		String url = "";
		do {			
			System.out.println("Enter hostname URL");
			System.out.println("ie: 'https://www.cincinnatistate.edu' ");
			System.out.println("Hostname: ");
			url = getStringFromUser();
		} while (url.length() < 0);
		return url;
	}

	
	/**
	 * Abstract: gets a filepath for file from user
	 * @return strValue string from user
	 */
	public static String getFilePath() {
		String filepath = "";
		do {
			System.out.println("Enter filepath");
			System.out.println("ie: 'CState.html' ");
			System.out.println("Filepath: ");
			filepath = getStringFromUser();
		} while (filepath.length() < 0);				
		return filepath;		
	}


	/** 
	 * Abstract: Reads line and returns string value.
	 * @return strValue string from user
	 */
	public static String getStringFromUser() {		
		String strValue = "";		
		// Input stream
		BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));		
		try {
			// Read a line from the user
			strValue = burInput.readLine();
		}
		catch(Exception excError) {System.out.println(excError.toString());}		
		return strValue;
	}


	/**
	 * Abstract: where program starts execution.
	 * @param args parameters.
	 */
	public static void main(String[] args) {

		try {
			//String url & filepath; connect exception
			String url = getURLName(); // ie: "https://www.cincinnatistate.edu".
			String filePath = getFilePath(); // ie: "CState.html".

			//create an instance of url by using new URL
			URL urlObj = new URL(url);
			//open the urlObj Connection
			URLConnection urlCon = urlObj.openConnection();

			//populate the inputStream with urlCon get input
			InputStream inputStream = urlCon.getInputStream();
			//create an instance of reader BufferInputStream using the inputStream
			BufferedInputStream reader = new BufferedInputStream(inputStream);
			//create an instance of writer BufferOutputStream using the filePath
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));

			//define the buffer to read in the data
			byte[] buffer = new byte[4096];
			//initialize int bytesRead to nothing found
			int bytesRead = -1;
			//loop until you read all the data
			while ((bytesRead = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, bytesRead);
			}
			//close the output file 
			writer.close();
			//close the input file
			reader.close();			
		}
		catch (FileNotFoundException e) {System.out.println("Possible syntax error with url and filename: " + e);}
		catch (MalformedURLException e) {System.out.println("The specified URL is malformed: " + e);}
		catch (IOException e) {System.out.println("An I/O error occurred: " + e);}		
		catch (NullPointerException e) {System.out.println("Null Pointer Exception: " + e);}
		catch (Exception e) {e.printStackTrace();}
		finally {		
			//notify the user this is complete
			System.out.println("Processing Complete");
		}
	}
}
