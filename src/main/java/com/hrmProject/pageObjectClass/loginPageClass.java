package com.hrmProject.pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageClass {
	
	 WebDriver ldriver;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginbutton;

	// constructor

	public loginPageClass(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void setUserName(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String upass) {
		password.sendKeys(upass);
	}

	public void clickOnLoginButton() {
		loginbutton.click();
	}
}
