package action;

import helper.SiteFactory;

public class checkoutAction  extends SiteFactory{
	
	private SiteFactory sf;

	public checkoutAction(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}
	
	/**
	 * Method to enter random user details and continue
	 * @return
	 */
	public checkoutAction enterUserRegisterattionDetailsAndContinue() {
		sf.checkoutPage().clickOnRegistrationButton();
		sf.checkoutPage().enterRandomUserInfoAndContinue();
		return this;
	}
	
	/**
	 * Method to proceed to checkout with guest user
	 * @return
	 */
	public checkoutAction proceedAsGuestCheckout() {
		sf.checkoutPage().proceedAsGuestChecout();
		return this;
	}

}
