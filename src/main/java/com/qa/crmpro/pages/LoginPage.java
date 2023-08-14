package com.qa.crmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.crmpro.utils.ElementUtils;

public class LoginPage {
	public WebDriver DRIVER;
	public ElementUtils eleUtils;

	//param constructor
	public LoginPage(WebDriver driver) {
		this.DRIVER = driver;
		this.eleUtils = new ElementUtils(this.DRIVER);
	}
	

	/*
	 * //driver to be passed on to the forthcoming page 
	 * AccountsPage accountspage = new AccountsPage(driver);
	 */

	private By userNameLocator = By.cssSelector("div.input-group [placeholder=Username]");
	private By passwordLocator = By.cssSelector("div.input-group [placeholder=Password]");
	private By loginButtonLocator = By.cssSelector("input.btn-small");
	private By logoLocator = By.cssSelector("a.navbar-brand img.img-responsive");
	private By navigationMenusLocator = By.cssSelector("ul.nav li a");
	private By frameLocator = By.cssSelector("frame[name='mainpanel']");

	public List<WebElement> isNavigationMenuPresentInLoginPage() {
		// return driver.findElements(navigationMenusLocator);
		return eleUtils.getElements(navigationMenusLocator);
	}

	public boolean isLogoPresent() {

		return eleUtils.doIsDisplayed(logoLocator);
		// return driver.findElement(logoLocator).isDisplayed();
	}

	public CRMApp logging(String username, String password) {

		eleUtils.doSendKeys(userNameLocator, username);
		eleUtils.doSendKeys(passwordLocator, password);
		eleUtils.doClick(loginButtonLocator);
		eleUtils.wait_forFrameAndSwitchToIt(frameLocator, 10);
		
		// page chaining - method to return next landing page object is called Page Chaining.
		//return new AccountsPage(driver);
		//return driver;
		
		return new CRMApp(DRIVER);
		

	}
	
	
}
