package com.qa.democart.driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	Properties properties;
	private WebDriver driver;
	FileInputStream file = null;

	public Properties initProperties() {

		/**
		 * To pass argument from maven command line
		 */
		String environment = System.getProperty("environment");
		try {
			if (environment == null) {
				System.out.println("Running in the QA env. . . ");
				file = new FileInputStream("./src/test/resources/config/qa.config.properties");

				}
			else if (environment.equals("dev")) {
				System.out.println("Running in the DEV env. . . ");
				file = new FileInputStream("./src/test/resources/config/dev.config.properties");

				} 
			else if (environment.equals("stg")) {
				System.out.println("Running in the STG env. . . ");
				file = new FileInputStream("./src/test/resources/config/stg.config.properties");
				}
			}
		
			catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		try {

			properties = new Properties();
			properties.load(file);

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
		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		String urltolaunch = properties.getProperty("url").trim();

		driver.get(urltolaunch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;

	}

}
