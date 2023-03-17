package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name = 'uid']")
	@CacheLookup
	WebElement txtuserName;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement btnLogout;

	public void setUsername(String uname) {
		txtuserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

}
