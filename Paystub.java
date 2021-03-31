//
//
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This program will calculate the Gross Earnings, FICA tax (Medicare and Social Security taxes),
 *  Federal Tax Withheld, and Net Amount of the payroll check for each employee of a company. 
 * @author Devin Watters
 * @version 1.0
 */

public class Paystub {

	/**
	 * Asks for employee name From User
	 * @return strName Employee's name
	 */
	static String GetstrName() {
		String strName = "";
		strName = GetStringFromUser();
		return strName;		
	}

	/**
	 * Asks for Hourly Rate from user
	 * @return HourlyRate The amount paid each hour the emplyee works.
	 */
	static int GetHourlyRate() {
		int HourlyRate = 0;
		HourlyRate = GetintfromUser();
		return HourlyRate;
	}

	/**
	 * Asks for Hours Worked from user
	 * @return HoursWorked The amount of hours worked by employee.
	 */
	static int GetHoursWorked() {
		int HoursWorked = 0;
		HoursWorked = GetintfromUser();
		return HoursWorked;
	}

	/**
	 *  Asks for Tax Exemptions from user
	 * @return Exemptions Tax exemptions declared by the employee.
	 */
	static int GetExemptions() {
		int Exemptions = 0;
		Exemptions = GetintfromUser();
		return Exemptions;
	}

	/** 
	 * Asks for Marital Status from user
	 * @return MaritalStatus Employee's Marital Status.
	 */
	static String GetMaritalStatus() {
		String MaritalStaus = "";
		MaritalStaus = GetStringFromUser();
		return MaritalStaus;		
	}

	/**
	 *  Calcs an employee Gross Earnings
	 * @param HoursWorked the amount of hours worked by employee
	 * @param HourlyRate The amount paid each hour the emplyee works
	 * @return GrossEarning The gross pay earned before taxes
	 */
	public static double payCalc(double HoursWorked, double HourlyRate)
	{
		double GrossEarning = 0; 
		if (HoursWorked <= 40)
		{
			GrossEarning = (HourlyRate * HoursWorked);
		} 
		else
		{
			GrossEarning = (40 * HourlyRate) + ((HoursWorked - 40) * (HourlyRate * 1.5));
		}
		return GrossEarning;
	}

	/**
	 * Calcs FICA from gross earnings for employee
	 * @param Medicare Medicare income tax rate
	 * @param SocialSecurity Social security income tax rate
	 * @param GrossEarning Gross amount before taxes
	 * @return FICA Medicare and Social Security income Tax amount
	 */
	public static double FedTaxCalc (double Medicare, double SocialSecurity, double GrossEarning)
	{
		double FICA = 0;

		FICA = (Medicare * GrossEarning) + (SocialSecurity * GrossEarning);

		return FICA;
	}
	
	/**
	 * 
	 * @param Exemptions Number of tax exemptions
	 * @param ExempRate Rate per exemption
	 * @param GrossEarning Gross amount before taxes
	 * @param MaritalSatus Married or Single
	 * @return Witholding Federal Income Tax Withholding Amount
	 */
	public static double FedWitholdCalc (int Exemptions,double ExempRate, double GrossEarning, String MaritalSatus)
	{
		double Witholding = 0;
		double AdjustedGrossIncome = 0;
		
		
		AdjustedGrossIncome = GrossEarning -Exemptions * ExempRate;

		if (AdjustedGrossIncome > 0 && AdjustedGrossIncome <= 50) {
			Witholding = 0;
		}
		else if (AdjustedGrossIncome > 51 && AdjustedGrossIncome <= 500) {
			if (MaritalSatus.equalsIgnoreCase("married")) {
				Witholding = GrossEarning * 0.05;
			}
			else {
				Witholding = GrossEarning * 0.10;
			}
		}
		else if (AdjustedGrossIncome > 501 && AdjustedGrossIncome <= 2500) {
			if (MaritalSatus.equalsIgnoreCase("married")) {
				Witholding = 22.50 + (GrossEarning - 500) * 0.10;
			}
			else {
				Witholding = 45 + (GrossEarning - 500) * 0.15;
			}
		}
		else if (AdjustedGrossIncome > 2501 && AdjustedGrossIncome <= 5000) {
			if (MaritalSatus.equalsIgnoreCase("married")) {
				Witholding = 225.50 + (GrossEarning - 2500) * 0.15;
			}
			else {
				Witholding = 345 + (GrossEarning - 500) * 0.20;
			}
		}
		else if (AdjustedGrossIncome < 5001) {
			if (MaritalSatus.equalsIgnoreCase("married")) {
				Witholding = 600.50 + (GrossEarning - 5000) * 0.20;
			}
			else {
				Witholding = 845 + (GrossEarning - 5000) * 0.25;
			}
		}
		else {
			Witholding = 0;
		}

		return Witholding;
	}
	
	/**
	 * 
	 * @param GrossEarnings Gross amount before taxes
	 * @param FICA Medicare and Social Security income Tax amount
	 * @param Witholding Federal Income Tax Withholding Amount
	 * @return NetGross Gross after taxes and holdings.
	 */
	public static double TotalNet (double GrossEarnings, double FICA, double Witholding)
	{
		double NetGross = 0;

		NetGross = GrossEarnings - FICA - Witholding;

		return NetGross;
	}
	
	/**
	 * Adds a user inputed value to the end of an array
	 * 
	 *@param CompanyGross An Array containing GrossEarnings 
	 *@param GrossEarnings value to add to array
	 *@return NewGrossEarnings A new array with added value on end. 
	 */
	public static double[] AddToGrossArray(double CompanyGross[], double GrossEarnings)
	{
		double NewGrossEarnings[];

		int intNewSize = 0;
		int intIndex = 0;	
		
		if (CompanyGross.length < 0 || CompanyGross == null) {
			NewGrossEarnings = new double[0];
		}
		else {
			//Add 1 to array length
			intNewSize = CompanyGross.length + 1;
			NewGrossEarnings = new double[intNewSize];
		}
		//Add old values to new array
		for(intIndex = 0; intIndex < CompanyGross.length; intIndex += 1)
		{
			NewGrossEarnings[intIndex] = CompanyGross[intIndex];
		}

		//Add value at end; method call
		NewGrossEarnings[intIndex] = GrossEarnings;

		return NewGrossEarnings;
	}

	/**
	 * 
	 * @return strValue string from user
	 */
	public static String GetStringFromUser() {
		
		String strValue = "";		
		
		// Input stream
		BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;
		
		try {
			// Read a line from the user
			strValue = burInput.readLine( );
			}
		catch( Exception excError ) {
			System.out.println( excError.toString( ) );
			}
		
		return strValue;
	}
	
	/**
	 * 
	 * @return intValue integer from user
	 */
	public static int GetintfromUser() {

		int intValue = 0;
		try	{
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
	 * 
	 * @param CompayGross An Array containing GrossEarnings 
	 * @return dblTotal Grand Payroll Total
	 */
	public static double CalcGrandGross (double CompayGross[]) {
		double dblTotal = 0;
		int intIndex = 0;
		
		if(CompayGross.length > 0) {
			//True
			// Add array values			
			for(intIndex = 0; intIndex < CompayGross.length; intIndex += 1) {
				dblTotal += CompayGross[intIndex];
			}	
		}
		return dblTotal;
	}

	/**
	 * calls methods and functions in Class Paystub
	 * @param args agruments
	 */
	public static void main(String[] args) {
		
		String Next = "";
		double CompanyGross[] = new double[0];
		double TotalCoGross = 0.0;
		String strContinue = "QUIT";
		
		do {
		// User input variables
		String strName = "";
		int HourlyRate = 0;
		int HoursWorked = 0;
		int Exemptions = 0;
		String MarritalStatus ="";
		
		
		// Tax Rates
		final double Medicare = 0.062;
		final double SocialSecurity = 0.0145;
		final double ExempRate = 55.77;

		// Calc Variables
		double GrossEarnings = 0.0;
		double FICA = 0.0;
		double Witholding = 0.0;
		double NetEarning = 0.0;

		// Gets strName
		System.out.print("Employee's Name: ");
		strName = GetstrName();
		// Gets HourlyRate
		System.out.print("Employee's Hourly Rate: ");
		HourlyRate = GetHourlyRate();
		// Gets Hoursworked
		System.out.print("Hours Worked by Employee: ");
		HoursWorked = GetHoursWorked();
		// Gets Federal Income Tax Withholding exemption(s)
		System.out.print("Number of exemptions declared by employee: ");
		Exemptions = GetExemptions();
		do {
		// Gets MaritalStatus
		System.out.print("Marital Status of employee (Married or Single only): ");
		MarritalStatus = GetMaritalStatus();
		MarritalStatus = MarritalStatus.trim();
		}while(MarritalStatus.equalsIgnoreCase("MARRIED") || MarritalStatus.equalsIgnoreCase("SINGLE"));
		//Calcs Gross Earnings with or without overtime
		GrossEarnings = payCalc(HoursWorked, HourlyRate);	
		//Calcs FICA Tax based off of Gross Earnings 
		FICA = FedTaxCalc(Medicare, SocialSecurity, GrossEarnings);
		//Calc Federal Income Tax Withheld
		Witholding = FedWitholdCalc(Exemptions, ExempRate, GrossEarnings, MarritalStatus);
		//Calcs Net Gross  
		NetEarning = TotalNet(GrossEarnings, FICA, Witholding);
		// Adds GrossEarnings to array CompanyGross
		CompanyGross = AddToGrossArray(CompanyGross, GrossEarnings);
		
		//Displays 
		System.out.print("\n");
		System.out.printf("----Employee %s's Summary----\n", strName);
		System.out.printf("Gross Earnings:              %8.2f \n", GrossEarnings);
		System.out.printf("FICA:                        %8.2f \n", FICA);
		System.out.printf("Federal Income Tax Withheld: %8.2f \n", Witholding);
		System.out.printf("Net Earnings:                %8.2f \n", NetEarning);
		
		// Contine clause
		System.out.print("\n");
		System.out.print("Next or QUIT?");
		Next = GetStringFromUser();
		Next = Next.trim();
		}while(!Next.equalsIgnoreCase(strContinue));
		
		// Calc for Grand Payroll Total
		System.out.print("\n");
		TotalCoGross = CalcGrandGross(CompanyGross);
		System.out.printf("Grand Payroll Total:         %8.2f \n", TotalCoGross);
	}
}














