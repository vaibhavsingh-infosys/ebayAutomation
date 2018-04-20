package utils;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "checkOutData")
	public static Object[][] credentials() {
       return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
	}
	
}
