package action;

import org.testng.Assert;
import org.testng.Reporter;

import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class productAction  extends SiteFactory{
	SiteFactory sf;
	public productAction(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}

	public productAction verifyProductPageAndNavigateToCart() {
		sf.productDetailPage().verifyProductPageAndNavigateToCart();
		return this;
	}
}

