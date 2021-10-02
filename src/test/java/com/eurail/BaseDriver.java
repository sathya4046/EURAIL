package com.eurail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {

	// instance of singleton class
	private static BaseDriver instanceOfBaseDriver = null;

	private WebDriver driver;
	//private WebDriverWait wait;

	// Constructor
	private BaseDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	// TO create instance of class
	public static BaseDriver getInstanceOfBaseDriver() {
		if (instanceOfBaseDriver == null) {
			instanceOfBaseDriver = new BaseDriver();
		}
		return instanceOfBaseDriver;
	}

	// To get driver
	public WebDriver getDriver() {
		return driver;
	}

}
