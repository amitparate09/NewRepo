package com.hrmProject.testClass;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hrmProject.pageObjectClass.BaseClass;
import com.hrmProject.pageObjectClass.loginPageClass;
import com.hrmProject.utilities.Exceldata;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void loginVerify() throws InterruptedException, IOException, InvalidFormatException {
		
		test = extent.createTest("Verification of application login");
		
		loginPageClass login = new loginPageClass(driver);
		
		
		Thread.sleep(2000);
		login.setUserName(Exceldata.getData(1, 0));
		test.log(Status.PASS, "username successfully entered");

		
		Thread.sleep(2000);
		login.setPassword(Exceldata.getData(1, 1));
		test.log(Status.PASS, "password successfully entered");
		
		Thread.sleep(2000);
		login.clickOnLoginButton();
		test.log(Status.PASS, "clicked on login button");

		String pageTitle = "OrangeHRM";
		Thread.sleep(2000);
		
		if (driver.getTitle().equals(pageTitle)) 
		{
			System.out.println("User logged in successfully");
			test.log(Status.PASS, "user logged in to the application successfully");
			
			String screenshotpath = BaseClass.captureScreen();
			test.addScreenCaptureFromPath(screenshotpath);
		} else 
		{
			System.out.println("User login failed");
		}

	}
}
