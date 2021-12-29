package com.sbi.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sbi.pageObjects.LoginPage;

@Listeners(com.sbi.listeners.Listener.class)
public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {

		driver.get(baseUrl);
		Reporter.log("URL is opened", true);

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		Reporter.log("Entered Username", true);

		lp.setPassword(password);
		Reporter.log("Entered Password", true);

		lp.clickSubmit();
		Reporter.log("Clicked Login button", true);
		Thread.sleep(2);
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			Reporter.log("Login Test Passed", true);

		} else {
			Assert.assertTrue(false);
			Reporter.log("Login Test Failed", true);

		}
	}

}
