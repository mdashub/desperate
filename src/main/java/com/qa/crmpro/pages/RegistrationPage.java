package com.qa.crmpro.pages;

import org.openqa.selenium.By;

public class RegistrationPage {

	//ElementUtils eleUtils;
	//WebDriver driver;
	private CRMApp crmApp;

	public RegistrationPage(CRMApp crmApp) {
		this.crmApp = crmApp;
		
		/*
		 * this.driver = driver; this.eleUtils = new ElementUtils(driver);
		 */

	}

	private By firstNameLocator = By.cssSelector("input#first_name");
	private By saveLocator = By.cssSelector("form#contactForm input[value='Save']");
	/*
	 * private By middleNameLocator = By.className("input#middle_initial"); private
	 * By lastNameLocator = By.className("input#surname");
	 */

	// private By ownerLocatorNextPage =
	// By.xpath("//div[@id='vSummary']//td[contains(text(), 'mangala')]");
	private By ownerLocatorRegPage = By.cssSelector("select#owner_user_id");

	// private By landingPageLocator =
	// By.xpath("//td[@class='tabs_header']//input[@type='button']");
	private By contactsLocator = By.cssSelector("a[title *=Contacts]");
	private By newContactsLocators = By.cssSelector("a[title*='New Contact']");
	
	public void isNavigatingToNewContacts() {
		crmApp.eleUtils.TwolevelMenuHandle(contactsLocator, newContactsLocators);
	}
	
	public String isOwnerSelected() {
		return crmApp.eleUtils.doGetText(ownerLocatorRegPage);
	}

	public String isAlertTextTestForUnsuccessfulRegistartion(String firstName) {

		crmApp.eleUtils.wait_forElementToBeClickable(firstNameLocator, 5);
		crmApp.eleUtils.doSendKeys(firstNameLocator, firstName);

		// eleUtils.doSendKeys(middleNameLocator, middleName);
		// eleUtils.doActionsSendKeys(middleNameLocator, middleName);
		// eleUtils.doSendKeys(middleNameLocator, middleName);
		// eleUtils.doSendKeys(lastNameLocator, lastName);

		// driver.findElement(saveLocator).click();
		crmApp.eleUtils.doClick(saveLocator);

		return crmApp.eleUtils.wait_forAlertText(10).trim();

	}

	/*
	 * public EndPage isholdingNextLandingPageObject() {
	 * 
	 * // boolean flag = eleUtils.wait_forElemnetInsivilibity(landingPageLocator,
	 * 10);
	 * 
	 * return new EndPage(driver); }
	 */
}
