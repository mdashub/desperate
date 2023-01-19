package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtils;

public class LoginPage {
	private WebDriver driver;
	private ElementUtils eleUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);
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

	public List<WebElement> isNavigationMenuPresentInLoginPage() {
		// return driver.findElements(navigationMenusLocator);
		return eleUtils.getElements(navigationMenusLocator);
	}

	public boolean isLogoPresent() {

		return eleUtils.doIsDisplayed(logoLocator);
		// return driver.findElement(logoLocator).isDisplayed();
	}

	public AccountsPage logging(String username, String password) {

		/*
		 * driver.findElement(userNameLocator).sendKeys(username);
		 * driver.findElement(passwordLocator).sendKeys(password);
		 * driver.findElement(loginButtonLocator).click();
		 */

		eleUtils.doSendKeys(userNameLocator, username);
		eleUtils.doSendKeys(passwordLocator, password);
		eleUtils.doClick(loginButtonLocator);
		
		
		// page chaining - method to return next landing page object is called Page Chaining.
		return new AccountsPage(driver);
		

	}
	
	
}
