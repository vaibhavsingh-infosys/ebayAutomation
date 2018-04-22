package pages;

import helper.ProductEntity;
import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class cartPage {

	public cartPage(SiteFactory siteFactory) {
	}
	
	Locator productName=new Locator("text.prodName", "Product name in cart page");
	Locator productPrice=new Locator("text.prodPrice", "Product price in cart page");
	Locator sellerName=new Locator("text.selName", "Seller name in cart page");
	Locator unitCount=new Locator("text.unitCount", "Unit count text in cart page");
	Locator proceedToCheckout=new Locator("button.proceedToCheckout", "Proceed to checkout button");
	
	/**
	 * method to verify product details in cart - comparing it with PDP details
	 */
	public void verifyProductInCartPage() {
		ProductEntity pd=(ProductEntity)CustomUtils.context.get();
		CustomUtils.verifyContainsText(productName, pd.getProductName());
		CustomUtils.verifyContainsText(productPrice, pd.getProductPrice());
		CustomUtils.verifyContainsText(sellerName, pd.getSellerName());
		CustomUtils.verifyVisible(unitCount);
	}

	/**
	 * method to proceed to checkout
	 */
	public void navigateToCheckout() {
		CustomUtils.click(proceedToCheckout);
	}

}
