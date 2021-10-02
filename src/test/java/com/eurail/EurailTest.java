package com.eurail;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.eurail.ActionUtilities.WaitType;

public class EurailTest {

	static ActionUtilities au = new ActionUtilities();
	static final Logger logger = LogManager.getLogger(EurailTest.class.getName());

	public static void main(String args[]) throws IOException {

		//Get Driver instance
		BaseDriver driverInstance = BaseDriver.getInstanceOfBaseDriver();
		WebDriver driver = driverInstance.getDriver();

		//Maximize the window
		driver.manage().window().maximize();
		
		//Launch the URL
		driver.get("https://www.interrail.eu/en");
		logger.debug(driver.getTitle());
		Assert.assertTrue("Page title doent match!!", driver.getTitle().contains("Interrail.eu"));

		//Handle Cookies pop
		au.waitForElement(Locators.COOKIE_ACCEPT_BTN, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.COOKIE_ACCEPT_BTN);
		
		//Navigation through menus to open Benelux country pass
		au.clickElement(Locators.INTERRAIL_PASSES_LNK);
		au.clickElement(Locators.ONE_COUNTRY_PASS_LNK);
		au.waitForElement(Locators.BENELUX_COUNTRY_PASS_LNK, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.BENELUX_COUNTRY_PASS_LNK);
		
		//Handle Cookies pop
		au.waitForElement(Locators.COOKIE_ACCEPT_BTN, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.COOKIE_ACCEPT_BTN);

		//Validating the adult pass is selected and has 1 quantity
		au.clickElement(Locators.CATEGORY_ADULT_PLUS_LINK);
		au.clickElement(Locators.CATEGORY_ADULT_MINUS_LINK);
		logger.debug("Quantity of Adult pass is :"+driver.findElement(Locators.ADULT_QUANTITY_TEXT).getAttribute("value"));
		Assert.assertEquals("Quantity of Adult pass is not 1", "1",driver.findElement(Locators.ADULT_QUANTITY_TEXT).getAttribute("value"));

		//selecting 2nd class pass
		au.clickElement(Locators.SECOND_CLASS_LNK);
		logger.debug("Second class pass selected.");

		//Adding it to cart
		au.clickElement(Locators.ADD_TO_CART_LNK);
		logger.debug("Clicked Add to cart button.");

		//Checking out basket
		au.waitForElement(Locators.CHECKOUT_BASKET_LNK, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.CHECKOUT_BASKET_LNK);
		logger.debug("Checkout Basket button clicked.");
		
		//Review Basket
		au.waitForElement(Locators.BASKET_REVIEW_CONTINUE_BTN, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.BASKET_REVIEW_CONTINUE_BTN);
		logger.debug("Review Basket button clicked.");


		//Login link click
		au.waitForElement(Locators.LOGIN_HERE_LNK, WaitType.ELEMENT_CLICKABLE);
		au.clickElement(Locators.LOGIN_HERE_LNK);
		logger.debug("Login here link is cliked");
		Assert.assertEquals("Value Matches", "Newtester01@mailinator.com", au.getPropertyValue("EMAILID"));
		
		//Logging in with given credentials
		driver.findElement(Locators.LOGIN_EMAIL_TXTBOX).sendKeys(au.getPropertyValue("EMAILID"));
		driver.findElement(Locators.LOGIN_PWD_TXTBOX).sendKeys(au.getPropertyValue("PWD"));
		au.clickElement(Locators.LOGIN_ACCOUNT_BTN);
		logger.debug("User logged in using the given credentials.");

		//Filling billing details and submitting it
		au.waitForElement(Locators.BILLING_FNAME_TXTBOX, WaitType.ELEMENT_PRESENCE);
		au.enterText(Locators.BILLING_FNAME_TXTBOX,"Jack");
		au.enterText(Locators.BILLING_LNAME_TXTBOX,"Robins");
		au.selectFromDropDown(Locators.BILLING_COUNTRY_DRPDOWN,"text","Italy");
		au.enterText(Locators.BILLING_CITY_TXTBOX,"Rome");
		au.enterText(Locators.BILLING_POSTALCODE_TXTBOX,"6633");
		au.enterText(Locators.BILLING_STREET_TXTBOX,"Colosseum lane");
		au.enterText(Locators.BILLING_PHONE_TXTBOX,"+3947656387");
		au.clickElement(Locators.BILLING_ORDER_DETAILS_BTN);
		
		//Fill travelers details
		au.waitForElement(Locators.TRAVELLER_DETAILS_GENDER_M, WaitType.ELEMENT_PRESENCE);
		au.enterText(Locators.TRAVELLER_DETAILS_GENDER_M,Keys.SPACE);
		au.enterText(Locators.TRAVELLER_DETAILS_FNAME_TXTBOX,"Jack");
		au.enterText(Locators.TRAVELLER_DETAILS_LNAME_TXTBOX,"Robins");

		driver.close();
	}
}