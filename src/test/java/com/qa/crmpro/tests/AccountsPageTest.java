package com.qa.crmpro.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.crmpro.pages.AccountsPage;
import com.qa.crmpro.pages.CRMApp;
import com.qa.crmpro.utils.Constants;

public class AccountsPageTest extends BaseTest {
	/*
	 * If crmApp reference is made private in LoginPageTest
	 */
	
	private CRMApp crmApp;
	private AccountsPage accountspage;
	
	
	@BeforeClass
	public void accountPageSetUp() {
		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		
		crmApp = loginpage.logging(username, password);
		accountspage = new AccountsPage(crmApp);
		
		//loginpage.logging(username, password,accountspage);
	}

	@Test(priority = 1)
	public void isNavigationMenuPresentInsideAccountsPageTest() {
		List<WebElement> menusAvailableOnLoginPageTest = accountspage.isNavigationMenuPresentInsideAccountsPage();
		Assert.assertEquals(menusAvailableOnLoginPageTest.size(), 62);
	}
	
	
	@Test(priority = 2, enabled =  true)
	public void isContactClickedTest() {
		accountspage.isClickingOnContacts();
	}
	@Test(priority = 3, enabled =  true)
	public void isOwnerSelectedTest() {
		Assert.assertEquals(accountspage.isOwnerSelected(),"mangala das", Constants.DISPLAY_MESSAGE);
	}
	
	@Test(priority = 4)
	public void isNavigatingToNewContactsTest() {
		//registrationpage = accountspage.isNavigatingToNewContacts();
		accountspage.isNavigatingToNewContacts();
		// can write assert for registration page 
	}

}
