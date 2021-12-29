package com.sbi.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sbi.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();

	public static WebDriver driver;
//	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

//		logger = Logger.getLogger("E-Banking");
//		PropertyConfigurator.configure("Log4j.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./" + "\\Screenshots\\" + tName + ".png");
		FileUtils.copyFile(source, target);
	}
}
