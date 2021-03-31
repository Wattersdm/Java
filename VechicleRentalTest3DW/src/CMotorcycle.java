
/**
* Abstract: 
* @author Devin Watters
* @since  5/28/202
* @version 2.1
* @see CVehicles
*/
public class CMotorcycle extends CVehicles {
	// How to drive vehicle	
	public void getHowToDrive() {
		System.out.println("Driven using Handle bars"); 
	}
	
	/**	
	*@param [intNewWheels] User integer input for number of wheels on vehicle.
	*/	
	public void setWheels( int intNewWheels) {
		if(intNewWheels < 0 || intNewWheels > 2) {
			System.out.println("Please try again");
			System.out.println("Enter number between 0 to 4 for MPG");	
		} else {
			m_intWheels = intNewWheels;
		}
	}
}
