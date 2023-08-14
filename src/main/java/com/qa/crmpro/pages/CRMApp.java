package com.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;

import com.qa.crmpro.utils.ElementUtils;

public class CRMApp {

	private WebDriver DRIVER;
	public ElementUtils eleUtils;

	public CRMApp (WebDriver driver) {
		this.DRIVER = driver;
		this.eleUtils = new ElementUtils(this.DRIVER);

	}

}
