/**
* Abstract: 
* @author Devin Watters
* @since  5/28/202
* @version 2.1
*/
public class CVehicles {
	
	protected String m_strType = "";
	protected int m_intWheels = 0;
	protected int m_intNumofMPG = 0;
	
	/**	
	*@param [strType] User string input for vehicle type.
	*/
	public void setType(String strType) {
		m_strType = strType;
	}
	
	// Method How to drive vehicle.
	public void getHowToDrive() {
		System.out.println("Drive What?"); 
	}
	
	/**	
	*@return [m_intNumofMPG] Returns Miles Per Gallion
	*/
	public int getMPG() {
		return m_intNumofMPG;
	}
	
	/**	
	*@param [intMPG] User integer input for MPG.
	*/
	public void setMPG(int intMPG) {
		
		if(intMPG < 0 || intMPG > 100 ) {
			System.out.println("Please try again");
			System.out.println("Enter number between 0 to 100 for MPG");
		} else {
			m_intNumofMPG = intMPG;
			//System.out.print("Vechicle MPG set successfully");
		}
	}
	
	/**	
	*@return [m_intWheels] Returns number of wheels on vehicle.
	*/
	public int getWheels() {
		return m_intWheels;
	}
	
	/**	
	*@param [intNewWheels] User integer input for number of wheels on vehicle.
	*/
	public void setWheels( int intNewWheels) {
		if(intNewWheels < 0 || intNewWheels > 4) {
			System.out.println("Please try again");
			System.out.println("Enter number between 0 to 4 for MPG");	
		} else {
			m_intWheels = intNewWheels;
		}
	}
	
	
}

	
	