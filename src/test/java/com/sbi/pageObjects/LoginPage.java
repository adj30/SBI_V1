package com.sbi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lDriver;

	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}

	public void setPassword(String uPassword) {
		txtPassword.sendKeys(uPassword);
	}

	public void clickSubmit() {
		btnLogin.click();
	}

}
