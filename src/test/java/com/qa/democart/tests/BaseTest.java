package com.qa.democart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.driverFactory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.EndPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.RegistrationPage;


public class BaseTest {
	Properties properties;
	DriverFactory driverfactory;
	LoginPage loginpage;
	AccountsPage accountspage;
	RegistrationPage registrationpage;

	EndPage endPage;
	
	protected WebDriver driver;

	@BeforeTest
	public void setUp() {
		driverfactory = new DriverFactory();
		properties = driverfactory.initProperties();
		driver = driverfactory.initDriver(properties);

		/*
		 * Passing the driver to login Page
		 * 
		 */
		loginpage = new LoginPage(driver);

	}

	
	  @AfterTest 
	  public void tearDown() {
	  System.out.println("Will Close the Browser"); driver.quit();
	  
	  }
	 

}
