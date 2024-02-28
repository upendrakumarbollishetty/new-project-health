package openmrs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelData.ExcelDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaptureVitals {

	WebDriver driver;
	private CharSequence username;
	private CharSequence password;

	@Test(priority = 1)
	@Given("I want to open the browser")
	public void i_want_to_open_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	@Given("I want to open the openmrs page")
	public void i_want_to_open_the_openmrs_page() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		FileReader reader=new FileReader("C:\\Users\\upend\\eclipse-workspace\\pavan projet\\HealthCare\\openmrslogin.properties"); 
        Properties props=new Properties(); 
        props.load(reader); 
//		driver.get("address1");
        driver.get(props.getProperty("address1"));
		Thread.sleep(1000);
	}
	
//	@Test(priority = 3,dataProviderClass =ExcelDataReader.class )
//	@DataProvider(name="LoginData")
	@When("I give login credentials")
	@Test(priority = 3)
	public void i_give_login_credentials() throws InterruptedException {
		
		
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		System.out.println("Username: " + username + ", Password: " + password);
		Thread.sleep(3000);
	}
	
	

	@Test(priority = 4)
	@When("I click on inpatient ward to access the location")
	public void i_click_on_inpatient_ward_to_access_the_location() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("Inpatient Ward")).click();
	}

	@Test(priority = 5)
	@When("I click on login")
	public void i_click_on_login() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("loginButton")).click();
	}

	@Test(priority = 6)
	@Then("It displays the home page and access capture vitals")
	public void it_displays_the_home_page_and_access_capture_vitals() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"referenceapplication-vitals-referenceapplication-vitals-extension\"]"))
				.click();
//driver.findElement(By.xpath("//*[@id=\"patient-search\"]")).sendKeys("100K18");
//		driver.findElement(By.xpath("//*[@id=\"patient-search\"]")).sendKeys("100J51");
		driver.findElement(By.xpath("//*[@id=\"patient-search\"]")).sendKeys("100JNX");
		// 100J51 100HVL
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"coreapps-vitals-confirm\"]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"w8\"]")).sendKeys("178");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w10\"]")).sendKeys("62");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w12\"]")).sendKeys("32");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w14\"]")).sendKeys("62");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w16\"]")).sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w18\"]")).sendKeys("120");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"w20\"]")).sendKeys("80");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"w22\"]")).sendKeys("90");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"confirmationQuestion\"]/p[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[1]/a/i")).click();
		Thread.sleep(1000);
//driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")).click();
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".png"));
		}
	}
	
	 @DataProvider(name = "loginData")
	    public Iterator<Object[]> getTestData() throws IOException {
	        String filePath = "C:\\Users\\upend\\eclipse-workspace\\pavan projet\\HealthCare\\LoginTestData.xlsx";
	        String sheetName = "Login";
	        List testData = (List) ExcelDataReader.readTestData(filePath, sheetName);
	        java.util.List<Object[]> testData2 = (java.util.List<Object[]>) testData;
			java.util.List<Object[]> list = testData2;
			return list.iterator();
	    }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) {
	        
	        System.out.println("Username: " + username + ", Password: " + password);
	    }


	public void teardown() {
		driver.close();
	}

}
