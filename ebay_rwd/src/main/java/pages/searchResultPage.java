package pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import helper.SiteFactory;
import utils.CustomUtils;
import utils.Locator;

public class searchResultPage {
	private SiteFactory sf;
	public searchResultPage(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}

	Locator searchResults=new Locator("list.searchResult", "Search result list");
	Locator tvSizeFilter=new Locator("checkbox.tvSizeFilter", "TV Size filter checkbox");
	Locator rightScrollFilter = new Locator("button.rightScrollFilter", "Right scroll filter");
	
	/**
	 * method to verify sr items contains all split values of search keyword
	 * @param searchKeyword
	 */
	public void verifySearchResultPage(String searchKeyword) {
		CustomUtils.verifyAllVisible(searchResults);
		for(String s : searchKeyword.split(" ")) {
			CustomUtils.verifyContainsTextList(searchResults,s);
		}
	}

	/**
	 * Select and verify filter option - if filter selected - name has price filter first number
	 * @param screenSize
	 */
	public void selectAndVerifySizeFilterOption(String screenSize) {
		if(!CustomUtils.isDisplayed(CustomUtils.format(tvSizeFilter, screenSize))){
			CustomUtils.click(rightScrollFilter);
		}
		CustomUtils.click(CustomUtils.format(tvSizeFilter, screenSize));
		CustomUtils.verifyContainsTextList(searchResults, screenSize.substring(0, 1));	
	}

	/**
	 * logic to select random item from SRP page
	 */
	public void selectRandomItemFromProductList() {
		int i=RandomUtils.nextInt(1, CustomUtils.getElements(searchResults).size());
		WebElement e=CustomUtils.getElements(searchResults).get(i);
		String name=e.getText();
		e.click();
		Reporter.log("Clicked on item : "+name);
	}

}
