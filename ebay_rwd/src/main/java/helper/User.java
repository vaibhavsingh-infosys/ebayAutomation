package helper;

import utils.CustomUtils;

/**
 * User class to manage Guest/Register user details
 * Start point of test execution
 * @author Vaibhav
 */
public class User {
	public static SiteFactory getFactory(){
		CustomUtils.setup();
		return new SiteFactory();
	}
	
	
	//Logic to read user data
}
