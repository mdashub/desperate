package com.qa.crmpro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.crmpro.utils.ElementUtils;

public class RegistrationPage {

	ElementUtils eleUtils;
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);

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

	public String isOwnerSelected() {
		return eleUtils.doGetText(ownerLocatorRegPage);
	}

	public String isAlertTextTestForUnsuccessfulRegistartion(String firstName) {

		eleUtils.wait_forElementToBeClickable(firstNameLocator, 5);
		eleUtils.doSendKeys(firstNameLocator, firstName);

		// eleUtils.doSendKeys(middleNameLocator, middleName);
		// eleUtils.doActionsSendKeys(middleNameLocator, middleName);
		// eleUtils.doSendKeys(middleNameLocator, middleName);
		// eleUtils.doSendKeys(lastNameLocator, lastName);

		// driver.findElement(saveLocator).click();
		eleUtils.doClick(saveLocator);

		return eleUtils.wait_forAlertText(10).trim();

	}

	public EndPage isholdingNextLandingPageObject() {

		// boolean flag = eleUtils.wait_forElemnetInsivilibity(landingPageLocator, 10);

		return new EndPage(driver);
	}

}
