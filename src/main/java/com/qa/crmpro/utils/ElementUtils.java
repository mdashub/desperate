package com.qa.crmpro.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;

	/**
	 * This is a parameterized constructor. Invoked and driver gets loaded with
	 * session ID via this. So we can use driver to communicate with Selenium
	 * Server.
	 * 
	 * @param driver
	 * @return - Contsructor don't return anything not even void.
	 */

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public List<WebElement> getElementsForJs(List<By> locator) {

		List<WebElement> listOfElement = new ArrayList<>();

		for (int i = 0; i < locator.size(); i++) {
			listOfElement.add(getElement(locator.get(i)));
		}
		return listOfElement;

	}

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 */

	public WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	/**
	 * 
	 * @param locatorType  as String
	 * @param locatorValue as String
	 * @return WebElement
	 */
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "tagName":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Wrong locatorType");
			break;
		}

		return locator;

	}

	/**
	 * This method first calls getElement with a locator parameter. Then send the
	 * values with established web element.
	 * 
	 * @param locator
	 * @param value
	 */

	public void doSendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);

	}

	/**
	 * This method first calls getElement with a locator parameter.Then click on
	 * that element located.
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * This method first calls getElement with a locator parameter.Then get the text
	 * of that element located.
	 * 
	 * @param locator
	 * @return
	 */

	public String doGetText(By locator) {
		return (getElement(locator)).getText().trim();

	}

	/**
	 * This method first calls getElement with a locator parameter.Then gets the
	 * attribute value of the attribute name
	 * 
	 * @param locator
	 * @param attributeName
	 * @return
	 */
	public String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);

	}

	/**
	 * This method first calls getElement with a locator parameter.Then checks for
	 * the element is displayed or not.
	 * 
	 * @param locator
	 * @return true or false
	 */
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();

	}

	/**
	 * This method first calls getElement with a locator parameter.Then checks for
	 * the element is enabled or not. An element displayed on the web-page maybe
	 * enabled or disabled.
	 * 
	 * @param locator
	 * @return true or false
	 */

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	/**
	 * This method is useful if we have 10 to 20 elements and we want to click on
	 * the particular text. Or the application is dynamic that it changes the order
	 * of the text every-time.This generic method is useful. However don't use this
	 * logic if we have 100 or 200 elements and we want to click on the particular
	 * link text.
	 * 
	 * @param locator
	 * @param value
	 */
	public void clickOnElementFromListOfWebelements(By locator, String value) {

		List<WebElement> elelist = getElements(locator);
		for (WebElement e : elelist) {
			String text = e.getText();

			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

	public List<String> getLinksTextList(By locator) {
		List<String> textList = new ArrayList();

		List<WebElement> eleList = getElements(locator);

		for (WebElement e : eleList) {
			String textOfElement = e.getText();
			if (!textOfElement.isBlank()) {
				textList.add(textOfElement);
			}
		}

		return textList;
	}

	public boolean isElementExist(By locator) {
		List<WebElement> list = driver.findElements(locator);
		if (list.size() > 0) {
			System.out.println("Element is present");
			return true;
		}

		System.out.println("Eelement is absent");
		return false;

	}

	/************************
	 * Drop Downs Util for Select HTML Tag
	 **************************/
	/**
	 * 
	 * @param locator
	 * @param visibleText
	 */
	public void doSelectDropdownByVisibleText(By locator, String visibleText) {

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);

	}

	/**
	 * 
	 * @param locator
	 * @param index
	 */

	public void doSelectDropdownByIndex(By locator, Integer index) {

		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	/**
	 * 
	 * @param locator
	 * @param value
	 */

	public void doSelectDropdownByvalue(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	/********************* Select Drop Down getOptions ************************/
	/**
	 * 
	 * @param locator
	 * @return
	 */

	public List<String> doSelectDropdownGetOptions(By locator) {

		Select select = new Select(getElement(locator));
		List<WebElement> webelements_OfDropdownValues = select.getOptions();
		List<String> list_TextofSelectDropdownValues = new ArrayList();
		for (WebElement e : webelements_OfDropdownValues) {
			list_TextofSelectDropdownValues.add(e.getText());
		}

		return list_TextofSelectDropdownValues;

	}

	/********************
	 * Select Drop Down values by clicking
	 **********************/

	/**
	 * 
	 * 
	 * @param locator
	 * @param valuesTobeSelected
	 */
	public void selectDropDownValues(By locator, String valuesTobeSelected) {
		Select select = new Select(getElement(locator));
		List<WebElement> webelements_OfDropdownValues = select.getOptions();
		for (WebElement e : webelements_OfDropdownValues) {
			if (e.getText().equals(valuesTobeSelected)) {
				e.click();
				break;

			}

		}
	}

	public void clickDropDownValues(By locator, String valuesTobeSelected) {

		List<WebElement> webelements_OfDropdownValues = getElements(locator);
		for (WebElement e : webelements_OfDropdownValues) {
			if (e.getText().equals(valuesTobeSelected)) {
				e.click();
				break;

			}

		}
	}

	/*****************************************
	 * J Query Drop Down
	 ****************************************/
	/**
	 * This method handle J query drop-down Single/Multi/All Selection of choices
	 * 
	 * @param locator
	 * @param selectDropDownValues
	 */
	public void choiceSelection(By locator, String... selectDropDownValues) {

		List<WebElement> choiceList = getElements(locator);

		if (!selectDropDownValues[0].equalsIgnoreCase("all")) {

			for (WebElement e : choiceList) {
				String text = e.getText();

				for (int i = 0; i < selectDropDownValues.length; i++) {
					if (text.equalsIgnoreCase(selectDropDownValues[i])) {
						e.click();
						break;

					}
				}

			}
		}

		else {
			for (WebElement e : choiceList) {
				if (!e.getText().isBlank()) {
					e.click();
				}

			}

		}

	}

	/****************** Actions Class **************************************/

	/**
	 * 
	 * @param locator_parentMenu1
	 * @param locator_childMenu1
	 */
	public void TwolevelMenuHandle(By locator_parentMenu1, By locator_childMenu1) {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(locator_parentMenu1)).perform();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {

		}
		act.moveToElement(getElement(locator_childMenu1)).click().build().perform();

	}

	/**
	 * @param locator_parentMenu1
	 * @param locator_parentMenu2
	 * @param locator_childMenu1
	 * @throws InterruptedException
	 */

	public void ThreelevelMenuHandle(By locator_parentMenu1, By locator_parentMenu2, By locator_childMenu1)
			throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(locator_parentMenu1)).perform();

		Thread.sleep(2000);

		act.moveToElement(getElement(locator_parentMenu2)).perform();

		Thread.sleep(2000);

		getElement(locator_childMenu1).click();

	}

	/**
	 * Context Click
	 * 
	 * @param locator
	 * @param conextMenusAvailable
	 * @param selectMenu
	 */

	public void doContextClick(By locator, By conextMenusAvailable, String selectMenu) {

		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();

		List<WebElement> all_contextMenu = getElements(conextMenusAvailable);

		for (WebElement e : all_contextMenu) {

			if (e.getText().equalsIgnoreCase(selectMenu)) {
				e.click();
				break;
			}
		}

	}

	/**
	 * Actions sendKeys
	 * 
	 * @param locator
	 * @param values
	 */

	public void doActionsSendKeys(By locator, String values) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), values).perform();
		;

	}

	/**
	 * Actions Click
	 * 
	 * @param locator
	 */
	public void doActionsClick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();

	}

	public void doActionsDoubleClick(By locator) {

		Actions act = new Actions(driver);
		act.doubleClick(getElement(locator)).perform();

	}

	/**
	 * Use with a map<key, value> pairs when more than one key and value are to be
	 * entered.
	 * 
	 * @param keyByLoactors_valueString
	 */

	public void doActionsSendKeysParametrIsMap(Map<By, String> keyIsByLoactors_valueIsString) {

		Actions act = new Actions(driver);

		for (Map.Entry<By, String> pair : keyIsByLoactors_valueIsString.entrySet()) {

			act.sendKeys(getElement(pair.getKey()), pair.getValue()).perform();

		}

	}

	/**
	 * Use with a list of clickable by locators in a page where you have more than
	 * one clicks to be done
	 * 
	 * @param clickable
	 */

	public void doActionClicksParametrIsList(List<By> clickable) {

		Actions act = new Actions(driver);

		for (int i = 0; i < clickable.size(); i++) {
			System.out.println(clickable.get(i));

			act.click(getElement(clickable.get(i))).perform();
		}

	}

	/***************************************
	 * Wait Utils
	 ***********************************/

	// Non WebElements

	/**
	 * -
	 * 
	 * @param timeOut
	 * @return
	 */
	public Alert wait_forAlertIsPresent(int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	// getting text of alert
	public String wait_forAlertText(int timeOut) {
		String textAlertPopUp = wait_forAlertIsPresent(timeOut).getText();
		wait_forAlertAccept(timeOut);
		return textAlertPopUp;
	}

	// accepting alert
	public void wait_forAlertAccept(int timeOut) {
		wait_forAlertIsPresent(timeOut).accept();
	}

	// dismissing alert
	public void wait_forAlertDismiss(int timeOut) {
		wait_forAlertIsPresent(timeOut).dismiss();
	}

	public void wait_forSendKeysInAlert(int timeOut, String text) {
		wait_forAlertIsPresent(timeOut).sendKeys(text);
		wait_forAlertAccept(timeOut);

	}

	public String wait_forTitleContains(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}

	public String wait_forTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}

	public String wait_forURLContains(String fractionURL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(fractionURL))) {
			return driver.getCurrentUrl();
		}

		return null;
	}

	public String wait_forURLToBe(String fullURL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(fullURL))) {
			return driver.getCurrentUrl();
		}

		return null;
	}

	// WebElement
	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public WebElement wait_forElementToBeVisibleUsingByLocators(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement wait_forElementToBeVisibleUsingWebElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));

	}

	public List<WebElement> wait_forElementsToBeVisibleUsingByLocator(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public List<String> wait_getElementsTextList(By locator, int timeOut) {
		List<WebElement> list = wait_forElementsToBeVisibleUsingByLocator(locator, timeOut);
		List<String> textList = new ArrayList<>();
		for (WebElement e : list) {
			textList.add(e.getText());
		}

		return textList;
	}

	public WebElement wait_forElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public WebElement wait_forElementToBeClickableElement(WebElement webElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(webElement));

	}

	public void clickWhenReady(By locator, int timeOut) {
		wait_forElementToBeClickable(locator, timeOut).click();
	}

	/*
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * 
	 * @param timeOut
	 * 
	 * @return
	 */

	public WebElement wait_forElementPresentInDOM(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return (wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
	}

	/**
	 * 
	 * @param locator
	 * @param timeOut
	 * @param timeInterval
	 * @return
	 */
	public WebElement wait_forElementPresentInDOM(By locator, int timeOut, int timeInterval) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return (wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
	}

	/**
	 * This method will check if the element is in-visibility. And Return true if not visible.
	 * Wisely  use it
	 * @param locator
	 * @param timeOut
	 * @return Boolean true when elements is not visible anymore.
	 */

	public boolean wait_forElemnetInsivilibity(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		return wait.until(ExpectedConditions.invisibilityOf(getElement(locator)));

	}

	/********************** Frame Utility ****************************************/
	/**
	 * An expectation for checking whether the given frame is available to switch
	 * to.
	 * 
	 * If the frame is available it switches the given driver to the specified
	 * webelement or locator
	 * 
	 * Parameters:frameLocator used to find the frame (webelement) /n
	 * Returns:WebDriver instance after frame has been switched
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void wait_forFrameAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getElement(locator)));

		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

	}

	/**
	 * 
	 * 
	 * An expectation for checking whether the given frame is available to switch
	 * to.
	 * 
	 * If the frame is available it switches the given driver to the specified
	 * frame./n Parameters:frameLocator used to find the frame (id or name)
	 * Returns:WebDriver instance after frame has been switched
	 * 
	 * @param frameName
	 * @param timeOut
	 */

	public void wait_forFrameAndSwitchToIt(String frameName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));

	}

	/**
	 * An expectation for checking whether the given frame is available to switch
	 * to.
	 * 
	 * If the frame is available it switches the given driver to the specified
	 * frameIndex. Parameters:frameLocator used to find the frame (index)
	 * Returns:WebDriver instance after frame has been switched
	 * 
	 * @param frmaeIndex
	 * @param timeOut
	 */

	public void wait_forFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));

	}

	/**************************** Fluent Wait ******************************/

	public WebDriver waitForFrameIsAvailableFluentWait(int timeOut, long pollingTime, By locator) {

		// Either use below FluentWait or WebDriverWait, both are same.
		// Wait wait1 = new FluentWait(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchMethodException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public WebElement waitForVisibilityOfElementWithFluentWait(int timeOut, long pollingTime, By locator) {

		// Either use below FluentWait or WebDriverWait, both are same.
		// Wait wait1 = new FluentWait(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchMethodException.class);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickableOfElementWithFluentWait(int timeOut, long pollingTime, By locator) {

		// Either use below FluentWait or WebDriverWait, both are same.
		// Wait wait1 = new FluentWait(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchMethodException.class);

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public Alert waitForAlertIsPresentWithFluentWait(int timeOut, long pollingTime, By locator) {

		// Either use below FluentWait or WebDriverWait, both are same.
		// Wait wait1 = new FluentWait(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchMethodException.class);

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/*********************** Custom Wait ****************************/

	public WebElement retryingElement(int maxAttempt, By locator) {

		WebElement element = null;
		int attempt = 0;

		while (attempt < maxAttempt) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (Exception e) {
				System.out.println("FirstCatch" + e);
				try {
					Thread.sleep(2000);
				}

				catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempt++;
		}
		return element;
	}

}