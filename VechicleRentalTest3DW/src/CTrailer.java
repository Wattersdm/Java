
/**
* Abstract: 
* @author Devin Watters
* @since  5/28/202
* @version 2.1
* @see CVehicles
*/
public class CTrailer extends CVehicles {
	// How to drive vehicle
	public void getHowToDrive() {
		System.out.println("Use another vechile to pull"); 
	}
	
	/**	
	*@param [intMPG] User integer input for MPG.
	*/			
	public void setMPG(int intMPG) {
		System.out.println("Does not require fuel.");
	}
	
	/**	
	*@return [-1] Returns nothing
	*/
	public int getMPG() {
		System.out.println("Does not require fuel.");
		return 0;
	}
}