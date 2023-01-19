package com.qa.democart.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority=2)
	public void isNavigationMenuPresentInLoginTest() {
		List<WebElement> menusAvailableOnLoginPageTest = loginpage.isNavigationMenuPresentInLoginPage();
		Assert.assertEquals(menusAvailableOnLoginPageTest.size(), 6);
	}
	
		
	@Test(priority = 1)
	public void isLogoPresentTest() {
		Assert.assertTrue(loginpage.isLogoPresent(), Constants.DISPLAY_MESSAGE);		
	}
	
	@Test(priority=3)
	public void loggingTest() {

		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		accountspage = loginpage.logging(username, password);
		
		// can write assert for accounts page 
	}
}
