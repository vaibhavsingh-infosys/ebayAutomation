package pages;

import org.apache.commons.lang3.RandomUtils;

import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class checkoutPage {

	public checkoutPage(SiteFactory siteFactory) {
		// TODO Auto-generated constructor stub
	}
	
	Locator regsitrationButton=new Locator("button.registrationSelect", "Registration select button");
	Locator firstName = new Locator("input.firstName", "First name field");
	Locator lastName = new Locator("input.lastName", "Last name field");
	Locator emailId = new Locator("input.emailId", "Email id field");
	Locator password = new Locator("input.password", "Password field");
	Locator continueButton = new Locator("button.continue", "Continue button");
	Locator guestCheckoutButton = new Locator("button.guestCheckout", "Guest checkout button"); 
	
	/**
	 * Mthod to click on Registration button
	 */
	public void clickOnRegistrationButton() {
		CustomUtils.click(regsitrationButton);
	}

	/**
	 * Method tofill random registration detail and continue
	 */
	public void enterRandomUserInfoAndContinue() {
		CustomUtils.sendKeys(firstName, "TestQA");
		CustomUtils.sendKeys(lastName, "Ïnfosys");
		CustomUtils.sendKeys(emailId, "InfosysTestQA"+RandomUtils.nextLong(100000, 1000000)+"@gmail.com");
		CustomUtils.sendKeys(password, "P@"+RandomUtils.nextInt(1000000, 10000000));
		CustomUtils.click(continueButton);
	}

	/**
	 * Method to proceed checkout as guest
	 */
	public void proceedAsGuestChecout() {
		CustomUtils.click(guestCheckoutButton);
	}

}
