package com.qa.democart.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	Properties properties;
	private WebDriver driver;
	FileInputStream file = null;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public Properties initProperties() {

		/**
		 * To pass argument from maven command line
		 */
		String env = System.getProperty("env");
		try {
			if (env.equals("QA")) {
				System.out.println("Running in the QA env. . . ");
				file = new FileInputStream("./src/test/resources/config/qa.config.properties");

			} else if (env.equals("dev")) {
				System.out.println("Running in the DEV env. . . ");
				file = new FileInputStream("./src/test/resources/config/dev.config.properties");

			} else if (env.equals("stg")) {
				System.out.println("Running in the STG env. . . ");
				file = new FileInputStream("./src/test/resources/config/stg.config.properties");
			}
		}

		catch (FileNotFoundException e) {
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
			// driver = new ChromeDriver();
			threadLocalDriver.set(new ChromeDriver());

		}
		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			threadLocalDriver.set(new ChromeDriver());
		}

		String urltolaunch = properties.getProperty("url").trim();

		getDriver().get(urltolaunch);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();

	}

	public WebDriver getDriver()

	{
		return threadLocalDriver.get();
	}

	/**
	 * Take screenshot
	 * 
	 */
	public String getScreenshot() {
		File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/mdas_screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(screenshotFile, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;

	}

}
