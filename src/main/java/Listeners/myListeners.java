package Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import base.Base;
import utilities1.ExtentReportGenerator1;

public class myListeners implements ITestListener{
	
	
	ExtentReports report = ExtentReportGenerator1.getExtentReport();
	ExtentTest eTest;
	
	public void onTestStart(ITestResult result) {
		
		String testName =result.getName();
		eTest = report.createTest(testName);
		eTest.log(Status.INFO, testName+"execution started");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getTestName();
		eTest.log(Status.PASS,testName+"got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getTestName();
		eTest.log(Status.FAIL,testName+"got failed");
		
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		//take the screen shots for failed tests
	
			eTest.addScreenCaptureFromPath(takesScreenshot(testName,driver),testName);
			eTest.log(Status.INFO,result.getThrowable());
	}
	private String takesScreenshot(String testName, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getTestName();
		eTest.log(Status.SKIP,testName+"got skipped");
		eTest.log(Status.INFO, result.getThrowable());	
	}
	public void onFinish(ITestContext context) {	
			
		File eReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		report.flush();	
		try {
			Desktop.getDesktop().browse(eReportFile.toURI());
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}






	
	


