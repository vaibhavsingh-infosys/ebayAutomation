package action;

import helper.SiteFactory;

public class searchAction  extends SiteFactory {
	public SiteFactory sf;
	public searchAction(SiteFactory siteFactory) {
		this.sf=siteFactory;
	}

	/**
	 * search for item
	 * @param searchKeyword
	 * @return
	 */
	public searchAction searchForItem(String searchKeyword) {
		sf.homePage().searchForItem(searchKeyword);
		return this;
	}

	/**
	 * verify srp
	 */
	public searchAction verifySearchResultPage(String searchKeyword) {
		sf.searchResultPage().verifySearchResultPage(searchKeyword);
		return this;
	}

	public searchAction selectAndVerifySizeFilterOption(String screenSize) {
		sf.searchResultPage().selectAndVerifySizeFilterOption(screenSize);
		return this;
	}

	public searchAction selectRandomItemFromProductList() {
		sf.searchResultPage().selectRandomItemFromProductList();
		return this;
	}

}
