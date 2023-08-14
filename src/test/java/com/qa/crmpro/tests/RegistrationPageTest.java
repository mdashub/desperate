package com.qa.crmpro.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crmpro.pages.CRMApp;
import com.qa.crmpro.pages.RegistrationPage;
import com.qa.crmpro.utils.Constants;

public class RegistrationPageTest extends BaseTest {

	private CRMApp crmApp ;
	private RegistrationPage registrationpage;
	
	@BeforeClass
	public void registrationPageSetUp() {
		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		crmApp = loginpage.logging(username, password);
		
		
		registrationpage = new RegistrationPage(crmApp);
		registrationpage.isNavigatingToNewContacts();
		
		//accountspage.isNavigationMenuPresentInsideAccountsPage();
		//accountspage.isClickingOnContacts();
		//accountspage.isNavigatingToNewContacts();
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
	public void isAlertTextTestForUnsuccessfulRegistartion(String firstName) {
		//System.out.println(Thread.currentThread().getId());
		String textinAlertPop = registrationpage.isAlertTextTestForUnsuccessfulRegistartion(firstName);
		Assert.assertEquals(textinAlertPop, Constants.ALERT_MESSAGE, Constants.DISPLAY_MESSAGE);
	}

//	@Test(priority = 3, enabled = false)
//	public void isholdingNextLandingPageObjectTest() {
//		endPage = registrationpage.isholdingNextLandingPageObject();
//	}
//	
	
}
