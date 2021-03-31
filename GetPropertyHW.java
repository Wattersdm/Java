import java.security.AccessControlException;


/**
 * Abstract: Demonstrate that you know how to get the following system properties:
	 			java installation directory, 
				user name,
				user directory, 
				operating system name, 
				operating system version,
	 			and the java class path. 
	 Establish a Security Manager. 
	 Print the Security Manager address. 
	 Attempt to change the user name system property. 
	 You must code for exceptions.
 * @author Devin Watters
 * @version 1.0
 *
 */
public class GetPropertyHW {

	 

	/**
	 * 
	 * @param args user defined args
	 */
	public static void main(String[] args) {

		/**
		 	No security manager is enabled by default. Thus all security checks 
		 	to protected resources and operations are disabled. In order to enable 
		 	security checks, the security manager must be enabled also
		 */

		// Security manager is disabled, read/write access to "user.name" system property is allowed
		System.setProperty("user.name", "Devin Watters");
				
		// java installation directory		
		System.out.println("java.home: " + System.getProperty("java.home"));
		// user name
		System.out.println("user.name is : " + System.getProperty("user.name"));
		// user directory
		System.out.println("user.dir: " + System.getProperty("user.dir")); 
		// prints the name of the Operating System
		System.out.println("os.name: " + System.getProperty("os.name")); 
		// Operating System Version 
		System.out.println("os.version: " + System.getProperty("os.version"));
		// java class path
		System.out.println("java.class.path: " + System.getProperty("java.class.path"));
		
		
		// get the reference to the Security Manager
		SecurityManager s = System.getSecurityManager();
		//check if null is returned
		if(s == null) {
			//no security manager
			System.out.println("The SecurityManager not been established.");
		}		

		try {
			//enable security manager
			SecurityManager securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
			System.out.println("Security Manager is set as " + System.getSecurityManager());
		} catch (SecurityException se) {
			// SecurityManager already set
			System.out.println("Security Manager is already set" + System.getSecurityManager());

		}
		try {
			// Security manager is enabled, read/write access to "user.name" system property is NOT allowed
			System.setProperty("user.name", "TLG2");
			System.out.println("Java User name is : " + System.getProperty("user.name"));
		} catch (AccessControlException ace) {
			System.out.println("Write access to the user.name system property is not allowed!");
		}

	}

}
