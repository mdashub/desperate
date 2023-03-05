package com.qa.crmpro.tests;

import org.testng.annotations.BeforeClass;


public class EndPageTest extends BaseTest {
	
	
	@BeforeClass
	public void endpageSetup() {
		String username = properties.getProperty("username").trim();
		String password = properties.getProperty("password").trim();
		accountspage = loginpage.logging(username, password);
		
		accountspage.isNavigationMenuPresentInsideAccountsPage();
		accountspage.isClickingOnContacts();
		registrationpage = accountspage.isNavigatingToNewContacts();
		
		
		endPage = registrationpage.isholdingNextLandingPageObject();
	}

}
