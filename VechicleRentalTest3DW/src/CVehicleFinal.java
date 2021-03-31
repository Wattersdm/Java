
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Abstract: Demonstrates the understanding of how to use object-oriented programming concepts, display data from a table in a database, obtain input from the user, validate user input, calculate totals, and display output.
 * 
 * @author Devin Watters
 * @since  5/28/2020
 * @version 2.1
 * @see DatabaseConnection
 */
public class CVehicleFinal extends DatabaseConnection{
	
	/**
	 * Shows TVehicles table from Access Database
	 */
	private static void displayDB() {
		try {
			// Can we connect to the database?
			if( OpenDatabaseConnectionMSAccess( ) == true) {
				//if ( OpenDatabaseConnectionSQLServer( ) == true )				
				// Pass in the table, primary key, and columns
				LoadListFromDatabase( "TVehicles", "intVehicleID" , "Type", "Make", "Model", "Year" );
			}
			else {
				// No, warn the user ...
				System.out.println("Error loading the table");
			}
			System.out.println("main : Process Complete");
		}
		catch (Exception e) {
			System.out.println("An I/O error occurred: " + e.getMessage());
		}
	}

	/**
	 * Gets Customer name
	 * @return strName Customer Name
	 */
	public static String getName() {
		String strName = "";
		System.out.print("Enter Customer's name: ");
		strName = usergetString();
		return strName;		
	}

	/**
	 * Gets String input from user
	 * @return strValue String input
	 */
	public static String usergetString() {
		String strValue = "";
		try	{
			String strBuffer = "";	
			// Input stream
			BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in));
			// Read a line from the user
			strBuffer = burInput.readLine( );
			strValue = (String) strBuffer;
		}
		catch( Exception excError ) {
			System.out.println( excError.toString( ) );
		}
		// Return integer value
		return strValue;
	}

	/**
	 * Gets Customer phone number
	 * @return strPhoneNumber Customer phone number.
	 */
	public static String getPhoneNumber() {
		boolean blnValid = false;
		String strPhoneNumber = "";
		do {
			System.out.print("Enter a valid Phone Number: ");
			strPhoneNumber = usergetString();
			blnValid = IsValidPhoneNumber(strPhoneNumber);
		} while (blnValid = false);
		return strPhoneNumber;
	}

	/**
	 * Checks if vaild phone number
	 * @param strPhoneNumber Checks if phone number is valid using regualr expressions
	 * @return true or false
	 */
	public static boolean IsValidPhoneNumber(String strPhoneNumber) {
		if (strPhoneNumber.matches("\\d{10}")) return true; //validate phone numbers of format "1234567890"
		else if (strPhoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true; //validating phone number where area code is in braces () 
		else return false; // returns false if not matching
	}

	/**
	 * Gets Customer email
	 * @return strEmail Customer Email
	 */
	public static String getEmail() {
		boolean blnValid = false;
		String strEmail = "";
		do {
			System.out.print("Enter a valid Email: ");
			strEmail = usergetString();
			blnValid = IsValidEmailAddress(strEmail);
		} while (blnValid = false);
		return strEmail;
	}

	/**
	 * Checks for valid email
	 * @param strEmail String Email
	 * @return true or false
	 */
	public static boolean IsValidEmailAddress(String strEmail) {
		String regex = "^(.+)@(.+)$";				
		Pattern pattern = Pattern.compile(regex);
		if (strEmail.matches(regex)) return true;
		else return false;
	}
	
	private static String getDate() {
		String strDate = "";
		boolean blnContinue = false;
		do {
		System.out.print("Enter Date of rental start(mm/dd/yyyy): ");
		strDate = usergetString();
		blnContinue = IsValidDate(strDate);
		}while (blnContinue = false);
		return strDate;
	}
	
	/**
	 * Checks for valid date
	 * @param strDate String date
	 * @return true or false
	 */
	public static boolean IsValidDate(String strDate) {
		String regex = "(?:1[6-9]|[2-9]\\d)";				
		Pattern pattern = Pattern.compile(regex);
		if (strDate.matches(regex)) return true;
		else return false;
	}
	
	
	/**
	 * Displays Customer info
	 * @param strName Customer Nmae
	 * @param strPhoneNumber Customer phone number
	 * @param strEmail Customer email
	 */
	private static void displayCustomer(String strName, String strPhoneNumber, String strEmail, String strDate) {
		System.out.print("Customer: " + strName + "\n");
		System.out.print("Phone Number: " + strPhoneNumber + "\n");
		System.out.print("Email: " + strEmail + "\n");
		System.out.print("Rental start date: " + strDate + "\n");
	}
	
	/**
	 * Gets days customer wishes to rent vehicle
	 * @return intRentalDays Days customer wishes to rent vehicle
	 */
	public static int getRentalDays() {	
		boolean blnContinue = false;
		int intRentalDays = 0;
		do {
			System.out.print("Enter number of days for rent: ");
			intRentalDays = usergetInt();
			if (!(intRentalDays <= 0)){
				blnContinue = true;
			}
		}while( blnContinue = false);
		return intRentalDays;
	}
	
	/**
	 * Gets integer input from user
	 * @return integer input
	 */
		public static int usergetInt() {
			int intValue = 0;
			try {
				String strBuffer = "";	
				// Input stream
				BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;
				// Read a line from the user
				strBuffer = burInput.readLine( );
				// Convert from string to integer
				intValue = Integer.parseInt( strBuffer );
			}
			catch( Exception excError ) {
				System.out.println( excError.toString( ) );
			}
			// Return integer value
			return intValue;
		}
	
	/**
	 * Creates a variable for number (1-3) of vehicles to rent
	 * @return NumOfVehicles
	 */
	public static int getNumOfVehicles() {
		int NumOfVehicles = 0;
		//User input determines value; do/while validates gets size
		do {
			System.out.print("Enter number of Vehicles to rent up to 3: ");
			NumOfVehicles = usergetInt();
		}while(NumOfVehicles < 0 || NumOfVehicles > 3);
		return NumOfVehicles;
	}
	
	/**
	 * Populates array with user inputed values.
	 * @param intNumOfVehicles  Number (1-3) of vehicles to rent
	 * @return astrVehicleTypes Vehicle type in an array
	 */
	public static String[] getastrVehicleTypes(int intNumOfVehicles)
	{
		int intIndex = 0;
		String strString = "";
		String[] astrVehicleTypes = new String[intNumOfVehicles];
		
		for(intIndex = 0; intIndex < intNumOfVehicles; intIndex+= 1) {
			boolean blnContinue = false;
			do {				
				System.out.print("Enter vehicle type for rental #" + (intIndex + 1) + ": ");
				astrVehicleTypes[intIndex] = usergetString();
				strString = astrVehicleTypes[intIndex].toLowerCase();
				strString.trim();
				if(strString.contentEquals("car") || strString.contentEquals("motorcycle") || strString.contentEquals("trailer")) {
					blnContinue = true;
				}
			} while (blnContinue = false);
		}
		return astrVehicleTypes;
	}
	/**
	 * Gets Customer info, Displays selection, and finally pricing.
	 * @param astrVehicleTypes array of vehicle type to rent
	 * @param intNumOfDays Number of days to rent
	 * @return dblGrandTotal Total for all vehicles for number of rental days.
	 */
	private static Double getRentalInfo(String[] astrVehicleTypes, int intNumOfDays) {
		Double dblCarRentalPrice = 150.00;
		Double dblMotorcycleRentalPrice = 100.00;
		Double dblTrailerRentalPrice = 75.00;
		int intMPG = 0;
		int intWheels = 0;
		Double dblRentalTotal = 0.0;
		Double dblGrandTotal = 0.0;
		
		CCar clsCar1 = new CCar();
		clsCar1.setType("Car");
		clsCar1.setMPG(40);
		clsCar1.setWheels(4);
				
		CMotorcycle clsBike1 = new CMotorcycle();
		clsBike1.setType("Motorcycle");
		clsBike1.setMPG(60);
		clsBike1.setWheels(2);
		
		CTrailer clsTrailer1 = new CTrailer();
		clsTrailer1.setType("Trailer");
		clsTrailer1.setWheels(3);
		
		int intIndex = 0;		
		for(intIndex = 0; intIndex < astrVehicleTypes.length; intIndex+= 1) {
			String strContinue = astrVehicleTypes[intIndex];
			
			if (strContinue.equals("car")) {
				System.out.print("Cars choices: \n");
				System.out.print("2016 Ford Escape\n");
				System.out.print("2018 Toyota Rav4\n");	
				System.out.println("Choices are made at pickup, based on avalaiblity");
				
				clsCar1.getHowToDrive();
				intMPG = clsCar1.getMPG();
				System.out.println("MPG: " + intMPG);
				intWheels = clsCar1.getWheels();
				System.out.println("Number of wheels on vehicle: " + intWheels);
				
				dblRentalTotal = dblCarRentalPrice * intNumOfDays;
				System.out.format("Total for this vehicle is $%.2f\n", dblRentalTotal);
			
			} else if (strContinue.equals("motorcycle")) {
				System.out.print("Motorcycle choices: \n");
				System.out.print("2000 Harley VR1000\n");
				System.out.print("2015 Kawasaki Vulcan S\n");
				System.out.println("Choices are made at pickup, based on avalaiblity");
				
				clsBike1.getHowToDrive();
				intMPG = clsBike1.getMPG();
				System.out.println("MPG: " + intMPG);
				intWheels = clsBike1.getWheels();
				System.out.println("Number of wheels on vehicle: " + intWheels);
				dblRentalTotal = dblMotorcycleRentalPrice * intNumOfDays;
				System.out.format("Total for this vehicle is $%.2f\n", dblRentalTotal);
			
			} else if (strContinue.equals("trailer")) {
				System.out.print("Trailer choices: \n");
				System.out.print("2015 Werx WX612\n");
				System.out.print("2015 Smittybilt Scout\n");
				System.out.println("Choices are made at pickup, based on avalaiblity");
				
				clsTrailer1.getHowToDrive();
				intMPG = clsTrailer1.getMPG();
				System.out.println("MPG: " + intMPG);
				intWheels = clsTrailer1.getWheels();
				System.out.println("Number of wheels on vehicle: " + intWheels);
				
				dblRentalTotal = dblTrailerRentalPrice * intNumOfDays;
				System.out.format("Total for this vehicle is $%.2f\n", dblRentalTotal);
			
			} else {
				System.out.println("An error occured, restart program.");
				
			}
			dblGrandTotal += dblRentalTotal;
		}
		return dblGrandTotal;
	}

	
	/**
	 *  Gets Customer info, Displays selection, and finally pricing.
	 */
	private static void customerTransaction() {
		String strName = "";
		String strPhoneNumber = "";
		String strEmail = "";
		int intRentalDays = 0;
		int intNumOfVehicles = 0;
		String[] astrVehicleTypes = new String[0];
		Double dblGrtandTotal = 0.0;
		String strDate = "";
		
		// Customer Name (getName)
		strName = getName();
		// Phone Number (getPhoneNumber)
		strPhoneNumber = getPhoneNumber();
		// Email (getEmail)
		strEmail = getEmail();
		// Date of Rental start
		strDate = getDate();
		// Num of Rental Days
		intRentalDays = getRentalDays();
		// Num of Rentals
		intNumOfVehicles = getNumOfVehicles();		
		// Rental type
		astrVehicleTypes = getastrVehicleTypes(intNumOfVehicles);		
		// Output Customer info
		displayCustomer(strName, strPhoneNumber, strEmail, strDate);
		// Rental Grand Total
		dblGrtandTotal = getRentalInfo(astrVehicleTypes, intRentalDays);
		System.out.printf("The Rental total for this transaction $%.2f\n", dblGrtandTotal );
	}
	

	/**
	 * calls methods and functions in Class CVehicleFinal
	 * @param args arguments
	 * 
	 */
	public static void main(String[] args) {
		// Displays the Vehicle Database
		displayDB();
		// Gets Customer info, Displays selection, and finally pricing.
		customerTransaction();	
	}
}


