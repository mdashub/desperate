package com.qa.democart.driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	Properties properties;
	private WebDriver driver;

	public Properties initProperties() {
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config/qa.config.properties");
			properties = new Properties();
			properties.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return properties;

	}

	public WebDriver initDriver(Properties properties) {

		String browserName = properties.getProperty("browser").trim();

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		String urltolaunch = properties.getProperty("url").trim();
		
		driver.get(urltolaunch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;

	}

}
