package com.qa.democart.tests;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.democart.pages.LoginPage;
import com.qa.democart.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accountPageSetUp() {
		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		accountspage = loginpage.logging(username, password);
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
		registrationpage = accountspage.isNavigatingToNewContacts();
		
		// can write assert for registration page 
	}

}
