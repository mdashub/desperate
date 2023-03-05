package com.qa.crmpro.pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;

import com.qa.crmpro.utils.ElementUtils;

public class EndPage {

	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	public EndPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);
	}
	
}
