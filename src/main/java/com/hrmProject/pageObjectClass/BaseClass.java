package com.hrmProject.pageObjectClass;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.hrmProject.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static WebDriver driver;

	@BeforeSuite
	public void setReport() {
		sparkreporter = new ExtentSparkReporter(
				"/Users/amitparate/Desktop/Second Workspace/Admin_Project_123/reports/newreport"+LocalDateTime.now()+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Operating System", "MacOS");
		extent.setSystemInfo("Environment", "SIT");
		sparkreporter.config().setReportName("Integration Test Execution");
		sparkreporter.config().setDocumentTitle("QA Automation Testing Report");
		sparkreporter.config().setTheme(Theme.STANDARD);

	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String str) {

		if (str.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/amitparate/Documents/Software_Testing_Application/geckodriver");
			
			HtmlUnitDriver unit = new HtmlUnitDriver(BrowserVersion.FIREFOX_ESR);

			unit.get(baseURL);

			// test.log(Status.PASS, "URL successfully open");
		} else if (str.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/amitparate/Documents/Software_Testing_Application/chromedriver_mac64/chromedriver");

			
			ChromeOptions option = new ChromeOptions();
			
			option.addArguments("headless");
			driver = new ChromeDriver(option);
			driver.get(baseURL);
			
		} else if (str.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					"/Users/amitparate/Documents/Software_Testing_Application/chromedriver_mac64/chromedriver");

			driver = new InternetExplorerDriver();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	
	public static String captureScreen() throws IOException
	{
		
		Random random = new Random();
		int x = random.nextInt(2000);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = "/Users/amitparate/Desktop/Second Workspace/Admin_Project_123/screenshots/newss"+".jpg";
		
		FileUtils.copyFile(source,new File(dest));
		
		return dest;
	}
	
	
	

}
