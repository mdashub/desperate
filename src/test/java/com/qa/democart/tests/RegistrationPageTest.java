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
	
	@Test(priority = 1, enabled =  true)
	public void isOwnerSelectedTest() {
		Assert.assertEquals(registrationpage.isOwnerSelected(),"mangala das (mdas1995)", Constants.DISPLAY_MESSAGE);
	}
	
	/*
	 * @DataProvider public Object [][] namesToBeRegistered() { Random random = new
	 * Random();
	 * 
	 * //Anonymous array return new Object[][]
	 * {{"Kim","Ann","Kardashian"+random.nextInt(20)} };
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 2, enabled =true, dataProvider = "namesToBeRegistered")
	 * public void isRegistrationSuccessfullTest(String firstName,String
	 * middleName,String lastName) { List<WebElement> listsize
	 * =registrationpage.isRegistrationSuccessfull( firstName, middleName,
	 * lastName); Assert.assertEquals(listsize.size(), 1); }
	 */
	
	@Test (priority = 3, enabled =true)
	public void isholdingNextLandingPageObjectTest() {
		endpage = registrationpage.isholdingNextLandingPageObject();
	}
	
	
	
}
