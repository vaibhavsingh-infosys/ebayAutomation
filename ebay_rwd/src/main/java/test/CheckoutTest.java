package test;

import org.testng.annotations.Test;

import helper.DataEntity;
import helper.User;
import utils.CustomDataProvider;

public class CheckoutTest {
	@Test(dataProvider="checkOutData", dataProviderClass=CustomDataProvider.class)
	public void GuestUser_CheckoutFlow(DataEntity data){	
		User.getFactory()
			
			._SearchAction()
				.searchForItem(data.getSearchKeyword())
				.verifySearchResultPage(data.getSearchKeyword())
				.selectAndVerifySizeFilterOption(data.getScreenSize())
				.selectRandomItemFromProductList()
			._ProductAction()
				.verifyProductPageAndNavigateToCart()
			._AddToCartAction()
				.verifyProductInCartPageAndNavigateToCheckout()
			._CheckoutAction() 
				//Guest option intermittent for checkout
				//For Guest/Registered user it is asking of call verification before proceeding to checkout - screenshot - //root folder/issue.jpg
				//.enterUserRegisterattionDetailsAndContinue()
				//.proceedAsGuestCheckout()

		;
	}
	
}
