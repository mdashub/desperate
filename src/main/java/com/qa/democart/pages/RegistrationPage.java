package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtils;

public class RegistrationPage {

	ElementUtils eleUtils;
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);

	}

	private By firstNameLocator = By.cssSelector("input#first_name");
	private By middleNameLocator = By.className("input#middle_initial");
	private By lastNameLocator = By.className("input#surname");
	private By saveLocator = By.className("form#contactForm input[value='Save']");
	private By ownerLocatorNextPage = By.xpath("//div[@id='vSummary']//td[contains(text(), 'mangala')]");
	private By ownerLocatorRegPage = By.cssSelector("select#owner_user_id");
	private By landingPageLocator = By.xpath("//td[@class='tabs_header']//input[@type='button']");

	public String isOwnerSelected() {
		return eleUtils.doGetText(ownerLocatorRegPage);
	}

	/*
	 * public List<WebElement> isRegistrationSuccessfull(String firstName, String
	 * middleName, String lastName) {
	 * 
	 * eleUtils.wait_forElementToBeClickable(firstNameLocator, 5);
	 * eleUtils.wait_forElementToBeClickable(middleNameLocatpr, 5);
	 * eleUtils.wait_forElementToBeClickable(lastNameLocator, 5);
	 * 
	 * WebElement e1 = driver.findElement(firstNameLocator); e1.click();
	 * e1.sendKeys("kelly"); WebElement e2 = driver.findElement(middleNameLocator);
	 * e2.click(); e2.sendKeys("kelly");
	 * 
	 * WebElement e3 = driver.findElement(lastNameLocator); e3.click();
	 * e3.sendKeys("kelly");
	 * 
	 * 
	 * 
	 * //eleUtils.doSendKeys(middleNameLocator, middleName);
	 * //eleUtils.doActionsSendKeys(middleNameLocator, middleName);
	 * //eleUtils.doSendKeys(middleNameLocator, middleName);
	 * //eleUtils.doSendKeys(lastNameLocator, lastName);
	 * 
	 * eleUtils.doClick(saveLocator);
	 * 
	 * return
	 * eleUtils.wait_forElementsToBeVisibleUsingByLocator(ownerLocatorNextPage, 10);}
	 */

	

	public EndPage isholdingNextLandingPageObject() {

		//boolean flag = eleUtils.wait_forElemnetInsivilibity(landingPageLocator, 10);

		return new EndPage(driver);
	}

}
