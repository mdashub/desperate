package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.crmpro.driverFactory.DriverFactory;
import com.qa.crmpro.pages.AccountsPage;
import com.qa.crmpro.pages.EndPage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.pages.RegistrationPage;

public class BaseTest {
	Properties properties;
	DriverFactory driverfactory;
	LoginPage loginpage;
	AccountsPage accountspage;
	RegistrationPage registrationpage;

	EndPage endPage;

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		driverfactory = new DriverFactory();
		properties = driverfactory.initProperties();
		driver = driverfactory.initDriver(properties);

		String urltolaunch = properties.getProperty("url").trim();
		driver.get(urltolaunch);

		/*
		 * Passing the driver to login Page
		 * 
		 */
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		System.out.println("Will Close the Browser");
		driver.quit();

	}

}
