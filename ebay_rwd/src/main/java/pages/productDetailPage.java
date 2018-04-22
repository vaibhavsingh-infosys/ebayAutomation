package pages;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import helper.ProductEntity;
import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class productDetailPage {

	public productDetailPage(SiteFactory siteFactory) {
		// TODO Auto-generated constructor stub
	}

	Locator timeleft =new Locator("text.timeLeft", "Time left text in PDP");
	Locator productPrice =new Locator("text.price", "Product price");
	Locator itemName = new Locator("text.itemName", "Product name");
	Locator sellerName = new Locator("text.sellerName", "Seller name");
	Locator addToCart = new Locator("button.atc", "Add to cart button");
	Locator goToCart = new Locator("button.goToCart", "Go to cart button");
	
	
	public void verifyProductPageAndNavigateToCart() {
		try {
			String tLeft=CustomUtils.getElement(timeleft).getText();
			boolean match= tLeft.matches("\\d+d \\d+h") | tLeft.matches("\\d+h \\d+m") | tLeft.matches("\\d+m \\d+s");
			if(match)
				Reporter.log("Time Left match verified");
			CustomUtils.c.get().sa.assertEquals(match, true);
		}catch (NoSuchElementException e) {
			CustomUtils.c.get().sa.fail("Time left text in PDP pagenot found");
		}
		
		String price=CustomUtils.getElement(productPrice).getText();
		CustomUtils.c.get().sa.assertEquals(price.matches("\\$\\d+,\\d{3}+\\.\\d{2}"), true);

		
		ProductEntity entity=new ProductEntity();
		entity.setProductName(CustomUtils.getElement(itemName).getText());
		entity.setProductPrice(price);
		entity.setSellerName(CustomUtils.getElement(sellerName).getText());
		CustomUtils.context.set(entity);
		
		CustomUtils.click(addToCart);
		if(CustomUtils.isDisplayed(goToCart))
			CustomUtils.click(goToCart);
	}

}
