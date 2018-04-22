package action;

import helper.SiteFactory;

public class addToCartAction extends SiteFactory{

	private SiteFactory sf;
	public addToCartAction(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}

	public addToCartAction verifyProductInCartPageAndNavigateToCheckout() {
		sf.cartPage().verifyProductInCartPage();
		sf.cartPage().navigateToCheckout();
		return this;
	}

}
