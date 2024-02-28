//package base;
//
//
//import java.io.File;
//
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class Base {
//
//	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
//		File sourceScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File destinationScreenshotFile1 = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
//		FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile1);
//		return testName;
//	}
//		
//}
		
	




//private TakesScreenshot driver;
//
//public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//	if (testResult.getStatus() == ITestResult.FAILURE) {
//		driver = null;
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
//				+ Arrays.toString(testResult.getParameters()) + ".png"));
//
//
//
//	}
//}
//}

