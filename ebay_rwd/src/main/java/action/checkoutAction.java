package action;

import helper.SiteFactory;

public class checkoutAction  extends SiteFactory{
	
	private SiteFactory sf;

	public checkoutAction(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}

	public checkoutAction enterUserRegisterattionDetailsAndContinue() {
		sf.checkoutPage().clickOnRegistrationButton();
		sf.checkoutPage().enterRandomUserInfoAndContinue();
		return this;
	}

	public checkoutAction proceedAsGuestCheckout() {
		sf.checkoutPage().proceedAsGuestChecout();
		return this;
	}

}
