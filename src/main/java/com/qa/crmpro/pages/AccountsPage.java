package com.qa.crmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crmpro.utils.ElementUtils;

public class AccountsPage {

	private ElementUtils eleUtils;
	private WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);
	}

	private By naveMenuInside = By.cssSelector("#navmenu li a");
	private By frameLocator = By.cssSelector("frame[name='mainpanel']");
	private By contactsLocator = By.cssSelector("div#navmenu li a[title='Contacts']");
	private By ownerLocator = By.cssSelector("tbody select[name='by_user'] option:nth-of-type(2)");
	private By newConatactLocator = By.cssSelector("div#navmenu li a[title='New Contact']");
	private By homeLocator = By.cssSelector("div#navmenu li a[title='Home']");

	public List<WebElement> isNavigationMenuPresentInsideAccountsPage() {
		eleUtils.wait_forFrameAndSwitchToIt(frameLocator, 10);
		return eleUtils.getElements(naveMenuInside);

	}

	public void isClickingOnContacts() {
		eleUtils.clickWhenReady(contactsLocator, 15);
	}

	public String isOwnerSelected() {
		return eleUtils.doGetText(ownerLocator);
	}

	public RegistrationPage isNavigatingToNewContacts() {
		eleUtils.clickWhenReady(homeLocator, 5);
		eleUtils.TwolevelMenuHandle(contactsLocator, newConatactLocator);

		return new RegistrationPage(driver);

	}

}
