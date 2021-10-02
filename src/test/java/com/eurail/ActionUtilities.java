package com.eurail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtilities {

	static final Logger logger = LogManager.getLogger(ActionUtilities.class.getName());

	public enum WaitType {
		ELEMENT_CLICKABLE, ELEMENT_PRESENCE, ELEMENT_VISIBLE
	}

	BaseDriver driverInstance = BaseDriver.getInstanceOfBaseDriver();
	WebDriver driver = driverInstance.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Properties prop = new Properties();

	public void waitForElement(By locator, WaitType wt) {

		switch (wt) {
		case ELEMENT_CLICKABLE:
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			logger.debug("Waited for element " + locator + " to be clickable.");
			break;
		case ELEMENT_PRESENCE:
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logger.debug("Waited for presence of element " + locator);
			break;
		case ELEMENT_VISIBLE:
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			logger.debug("Waited for visibility of element " + locator);
			break;
		default:
			break;

		}

	}

	public void clickElement(By locator) {
		waitForElement(locator, WaitType.ELEMENT_CLICKABLE);
		WebElement ele = driver.findElement(locator);
		ele.click();
		// logger.debug("Clicked on the element "+locator);
	}

	public void enterText(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
		logger.debug("Entered text" + value + " in field " + locator);
	}

	public void enterText(By locator, Keys value) {
		driver.findElement(locator).sendKeys(value);
		logger.debug("Pressed key " + value + " in field " + locator);
	}

	public void selectFromDropDown(By locator, String type, Object value) {
		Select slt = new Select(driver.findElement(locator));
		switch (type) {
		case "text":
			slt.selectByVisibleText((String) value);
			break;
		case "value":
			slt.selectByValue((String) value);
			break;
		case "index":
			slt.selectByIndex((int) value);
			break;
		}

		logger.debug("Selected " + value + " in dropdown " + locator);
	}

	public String getPropertyValue(String key) throws IOException {

		String value = null;

		try {
			FileReader reader = new FileReader("./src/test/resources/loginCreds.properties");
			Properties prop = new Properties();
			prop.load(reader);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return value;

	}

}