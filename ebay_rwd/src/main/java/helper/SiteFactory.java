package helper;

import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;
import pages.productDetailPage;
import pages.searchResultPage;

/**
 * To register page/action class objects to overcome object creation multiple times
 */
public class SiteFactory {	
	public cartPage cartPage(){
		return new cartPage(this);
	}
	
	public checkoutPage checkoutPage(){
		return new checkoutPage(this);
	}
	
	public homePage homePage(){
		return new homePage(this);
	}
	
	public productDetailPage productDetailPage(){
		return new productDetailPage(this);
	}
	
	public searchResultPage searchResultPage(){
		return new searchResultPage(this);
	}
}
