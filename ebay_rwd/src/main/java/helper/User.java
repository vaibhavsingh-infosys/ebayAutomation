package helper;

import utils.CustomUtils;

public class User {
	public static SiteFactory getFactory(){
		CustomUtils.setup();
		return new SiteFactory();
	}
	
	
	//Logic to read user data
}
