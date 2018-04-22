package pages;

import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class homePage {
	SiteFactory sf;
	public homePage(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}
	
	Locator searchField=new Locator("input.searchTextField", "Search input in home page");
	Locator searchButton=new Locator("button.searchButton", "Search button in home page");

	
	public void searchForItem(String searchKeyword) {
		CustomUtils.sendKeys(searchField,searchKeyword);
		CustomUtils.click(searchButton);
	}

}
