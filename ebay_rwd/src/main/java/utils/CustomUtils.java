package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import reportingUtils.CustomSoftAssert;

public class CustomUtils {
	public static ThreadLocal<CustomUtils> c=new ThreadLocal<CustomUtils>();
	public static Properties properties=new Properties();
	public static ThreadLocal<Object> context=new ThreadLocal<Object>();
	public RemoteWebDriver driver = null;
	public WebDriverWait wait=null;
	public CustomSoftAssert sa=new CustomSoftAssert();
	
	public static void setup() {
		c.set(new CustomUtils());
		
		try {
			properties.load(new FileInputStream(new File("src/main/resources/config/test.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DesiredCapabilities capabilities; 

		switch (properties.getProperty("browser")) {
		case "chrome":
			capabilities = DesiredCapabilities.chrome();
			break;
		case "firefox":
			capabilities = DesiredCapabilities.firefox();
			break;
		case "ie":
			capabilities = DesiredCapabilities.internetExplorer();
			break;
		default:
			capabilities = DesiredCapabilities.chrome();
		}
		
		try {
			c.get().driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		c.get().driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		c.get().wait=new WebDriverWait(c.get().driver, 30);
		c.get().driver.manage().window().maximize();
		c.get().driver.get(properties.getProperty("siteURL"));
		Reporter.log("Navigate to EBAY home page");
		ReportListener.test.get().setMsg("Navigate to EBAY home page");
	}

	public static WebElement getElement(Locator locator) {
		WebElement ele = null;
		switch (locator.getType()) {
		case id:
			ele=CustomUtils.c.get().driver.findElement(By.id(locator.getLoc()));
			break;
		case xpath:
			ele=CustomUtils.c.get().driver.findElement(By.xpath(locator.getLoc()));
			break;
		case classs:
			ele=CustomUtils.c.get().driver.findElement(By.className(locator.getLoc()));
			break;
		case css:
			ele=CustomUtils.c.get().driver.findElement(By.cssSelector(locator.getLoc()));
			break;
		default:
			break;
		}
		return ele;
	}
	
	public static List<WebElement> getElements(Locator locator) {
		List<WebElement> ele = null;
		switch (locator.getType()) {
		case id:
			ele=CustomUtils.c.get().driver.findElements(By.id(locator.getLoc()));
			break;
		case xpath:
			ele=CustomUtils.c.get().driver.findElements(By.xpath(locator.getLoc()));
			break;
		case classs:
			ele=CustomUtils.c.get().driver.findElements(By.className(locator.getLoc()));
			break;
		case css:
			ele=CustomUtils.c.get().driver.findElements(By.cssSelector(locator.getLoc()));
			break;
		default:
			break;
		}
		return ele;
	}
	
	public static void sendKeys(Locator locator, String keyword) {
		getElement(locator).sendKeys(keyword);
		Reporter.log("Type \""+keyword+"\" in \""+locator.getDesc()+"\"");
		ReportListener.test.get().setMsg("Type \""+keyword+"\" in \""+locator.getDesc()+"\"");
	}
	
	public static void click(Locator locator) {
		c.get().wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
		getElement(locator).click();
		Reporter.log("Click on \""+locator.getDesc()+"\"");
		System.out.println("Click on \""+locator.getDesc()+"\"");
		ReportListener.test.get().setMsg("Click on \""+locator.getDesc()+"\"");
	}
	
	public static void verifyVisible(Locator locator) {
		c.get().wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
		c.get().sa.assertEquals(getElement(locator).isDisplayed(), true);
		Reporter.log("Verified visibility of \""+locator.getDesc()+"\"");
		ReportListener.test.get().setMsg("Verified visibility of \""+locator.getDesc()+"\"");
	}
	
	public static void verifyAllVisible(Locator locator) {
		c.get().wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
		for(WebElement ele:getElements(locator))
			c.get().sa.assertEquals(ele.isDisplayed(), true);
		Reporter.log("Verified visibility of all elements located by \""+locator.getDesc()+"\"");
		ReportListener.test.get().setMsg("Verified visibility of all elements located by \""+locator.getDesc()+"\"");
	}
	
	public static void verifyContainsText(Locator locator, String expectedText) {
		System.out.println(getElement(locator).getText()+"  - - -  "+expectedText);
		c.get().sa.assertEquals(getElement(locator).getText().contains(expectedText) | expectedText.contains(getElement(locator).getText()), true);
		Reporter.log("Verified \""+locator.getDesc()+"\" contains \""+expectedText+"\"");
		ReportListener.test.get().setMsg("Verified \""+locator.getDesc()+"\" contains \""+expectedText+"\"");
	}
	
	public static boolean isDisplayed(Locator locator) {
		boolean disp=false;
		try {
			c.get().wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
			disp=getElement(locator).isDisplayed();
		}catch (NoSuchElementException|TimeoutException e) {
			disp=false;
		}
		return disp;
	}
	
	public static void verifyContainsTextList(Locator locator, String expectedText) {
		for(WebElement ele:getElements(locator)) {
			c.get().sa.assertEquals(ele.getText().toLowerCase().contains(expectedText.toLowerCase()), true,"Text : "+expectedText+" not found in \""+ele.getText()+"\"");
		}
		Reporter.log("Verified all element of \""+locator.getDesc()+"\" contains \""+expectedText+"\"");
		ReportListener.test.get().setMsg("Verified all element of \""+locator.getDesc()+"\" contains \""+expectedText+"\"");
	}
	
	public static Locator format(Locator locator, String... text) {
		String l="";
		for(int i=0; i<text.length;i++) {
			l=locator.getLoc().replace("{"+i+"}", text[i]);
		}
	
		return new Locator(l, locator.getDesc(),locator.getType());
	}
}
