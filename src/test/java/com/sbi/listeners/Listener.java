package com.sbi.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.sbi.testCases.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	BaseClass base = new BaseClass();

	public void onTestFailure(ITestResult result) {
		Reporter.log("Screen Shot Taken start", true);
		String tcname = result.getName();

		try {
			base.captureScreenshot(driver, tcname);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reporter.log("Screen Shot Taken end", true);

	}
}