package utilities1;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator1 {
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports report = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		report.attachReporter(sparkReporter);
		return report;
	}

}








