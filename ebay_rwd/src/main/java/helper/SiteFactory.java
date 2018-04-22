package helper;

import action.addToCartAction;
import action.checkoutAction;
import action.productAction;
import action.searchAction;
import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;
import pages.productDetailPage;
import pages.searchResultPage;
import utils.CustomUtils;

/**
 * To register page/action class objects to overcome object creation multiple times
 */
public class SiteFactory {
	public SiteFactory() {
	}
	
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
	
	public productAction _ProductAction() {
		return new productAction(this);
	}
	
	public addToCartAction _AddToCartAction() {
		return new addToCartAction(this);
	}
	
	public searchAction _SearchAction() {
		return new searchAction(this);
	}
	
	public checkoutAction _CheckoutAction() {
		return new checkoutAction(this);
	}
}
