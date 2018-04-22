package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import reportingUtils.TestObject;

/**
 * Custom report listener - creates json file, screenshot on failure
 * @author Vaibhav
 *
 */
public class ReportListener implements ITestListener {
	public static ThreadLocal<TestObject> test;
	List<TestObject> tests =new ArrayList<TestObject>();
	
	@Override
	public void onFinish(ITestContext arg0) {
		test.get().setEndTime(Calendar.getInstance().getTime());
		System.out.println(" "+Calendar.getInstance().getTime()+" Execeution Stopped : "+arg0.getName());
		Reporter.log((" "+Calendar.getInstance().getTime()+" Execeution Stopped : "+arg0.getName()));	
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(" "+Calendar.getInstance().getTime()+" Execeution Started : "+arg0.getName());
		Reporter.log(" "+Calendar.getInstance().getTime()+" Execeution Started : "+arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test.get().setEndTime(Calendar.getInstance().getTime());
		test.get().setAssertions(arg0.getThrowable().getMessage());
		TakesScreenshot scrShot =((TakesScreenshot)CustomUtils.c.get().driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("build/report/images/"+arg0.getName()+arg0.getEndMillis()+".jpg");
        try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.get().setScrURL(DestFile.getPath().replace("build\report\\", ""));
		test.get().setTestStatus("Fail");
		
		System.out.println(" "+Calendar.getInstance().getTime()+" Test Failed : "+arg0.getName());
		Reporter.log(" "+Calendar.getInstance().getTime()+" Test Failed : "+arg0.getName());  
		
		
		tests.add(test.get());
		
		Gson gson = new Gson();
        Type type = new TypeToken<List<TestObject>>() {}.getType();
        String json = gson.toJson(tests, type);
        System.out.println(json);
        File f=new File("build/report/testResult/report.json");
        f.getParentFile().mkdirs();
        FileWriter writer = null;
		try {
			writer = new FileWriter(f);
			writer.write("data = "+json);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		CustomUtils.c.get().sa.assertAll();
		CustomUtils.c.get().driver.quit();
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		TestObject to=new TestObject();
		to.setStartTime(Calendar.getInstance().getTime());
		to.setTestName(arg0.getName());
		test=new ThreadLocal<TestObject>();
		test.set(to);
		System.out.println(" "+Calendar.getInstance().getTime()+" Test Started : "+arg0.getName());
		Reporter.log(" "+Calendar.getInstance().getTime()+" Test Started : "+arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		test.get().setEndTime(Calendar.getInstance().getTime());
		test.get().setTestStatus("Pass");
		System.out.println(" "+Calendar.getInstance().getTime()+" Test Passed : "+arg0.getName());
		Reporter.log(" "+Calendar.getInstance().getTime()+" Test Passed : "+arg0.getName());
		
		Gson gson = new Gson();
        Type type = new TypeToken<List<TestObject>>() {}.getType();
        String json = gson.toJson(tests, type);
        System.out.println(json);
        File f=new File("build/report/testResult/report.json");
        f.getParentFile().mkdirs();
        FileWriter writer = null;
		try {
			writer = new FileWriter(f);
			writer.write("data = "+json);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		CustomUtils.c.get().sa.assertAll();
		CustomUtils.c.get().driver.quit();
		
	}
}
