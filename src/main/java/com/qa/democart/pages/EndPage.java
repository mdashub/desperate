package com.qa.democart.pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtils;

public class EndPage {

	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	public EndPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtils = new ElementUtils(driver);
	}
	
}
