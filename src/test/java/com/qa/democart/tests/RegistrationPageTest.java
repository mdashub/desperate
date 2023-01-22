package com.qa.democart.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registrationPageSetUp() {
		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		accountspage = loginpage.logging(username, password);
		accountspage.isNavigationMenuPresentInsideAccountsPage();
		accountspage.isClickingOnContacts();
		registrationpage = accountspage.isNavigatingToNewContacts();
	}

	@Test(priority = 1, enabled = true)
	public void isOwnerSelectedTest() {
		//System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(registrationpage.isOwnerSelected(), "mangala das (mdas1995)", Constants.DISPLAY_MESSAGE);
	}

	@DataProvider
	public Object[][] namesToBeChecked() {
		Random random = new Random();

		// Anonymous array.
		return new Object[][] { { "!#$%_-" + random.nextInt(20) }, 
			                    { "6666" + random.nextInt(20) },
			                    { "Kortney" + random.nextInt(20) }, 
			                    { "Kagney" + random.nextInt(20) }, 
			                    { "Cathy" + random.nextInt(20) },
			                    { "Angela" + random.nextInt(20) } };

	}

	@Test(priority = 2, enabled = true, dataProvider = "namesToBeChecked")
	public void isRegistrationUnsuccessfullTest(String firstName) {
		//System.out.println(Thread.currentThread().getId());
		String textinAlertPop = registrationpage.isRegistrationUnsuccessfull(firstName);
		Assert.assertEquals(textinAlertPop, Constants.ALERT_MESSAGE, Constants.DISPLAY_MESSAGE);
	}

	@Test(priority = 3, enabled = false)
	public void isholdingNextLandingPageObjectTest() {
		endpage = registrationpage.isholdingNextLandingPageObject();
	}
	
	
}
