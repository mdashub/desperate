package com.qa.crmpro.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.crmpro.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC: Login page feature" )
@Story("Squad 4 : All features")
public class LoginPageTest extends BaseTest {

	@Description("Checking Navigation menus in the Login Page")// from Allure
	@Severity(SeverityLevel.NORMAL)// from Allure
	@Test(priority = 2)
	
	public void isNavigationMenuPresentInLoginTest() {
		List<WebElement> menusAvailableOnLoginPageTest = loginpage.isNavigationMenuPresentInLoginPage();
		Assert.assertEquals(menusAvailableOnLoginPageTest.size(), 7);
	}

	@Description("Checking brand logo in Login Page")// from Allure
	@Severity(SeverityLevel.NORMAL)// from Allure
	@Test(priority = 1)
	
	public void isLogoPresentTest() {

		Assert.assertTrue(loginpage.isLogoPresent(), Constants.DISPLAY_MESSAGE);
	}

	@Description("Checking for the Login is successfull") // from Allure
	@Severity(SeverityLevel.CRITICAL) // from Allure
	@Test(priority = 3) //from TestNg
	
	public void loggingTest() {

		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		accountspage = loginpage.logging(username, password);

		// can write assert for accounts page
	}
}
