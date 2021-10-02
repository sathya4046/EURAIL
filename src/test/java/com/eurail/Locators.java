package com.eurail;

import org.openqa.selenium.By;

public class Locators {

	public static final By COOKIE_ACCEPT_BTN = By.xpath(
			"//div[@id=\"CybotCookiebotDialogBodyLevelButtonAcceptWrapper\"]/a[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]");

	public static final By INTERRAIL_PASSES_LNK = By.xpath("//a[@href=\"/en/interrail-passes\"]");

	public static final By ONE_COUNTRY_PASS_LNK = By
			.xpath("//a[@href=\"/content/interrail/en/interrail-passes/one-country-pass\"]");

	public static final By BENELUX_COUNTRY_PASS_LNK = By
			.xpath("//a[@href=\"/content/interrail/en/interrail-passes/one-country-pass/benelux\"]");

	public static final By CATEGORY_ADULT_PLUS_LINK = By.xpath(
			"//li[@class=\"category-item\"]//input[@id=\"categoryadult\"]/following-sibling::div//div[@class=\"button button-small button-plus\"]/a");

	public static final By CATEGORY_ADULT_MINUS_LINK = By.xpath(
			"//li[@class=\"category-item\"]//input[@id=\"categoryadult\"]/following-sibling::div//div[@class=\"button button-small button-minus\"]/a");

	public static final By ADULT_QUANTITY_TEXT = By.xpath(
			"//li[@class=\"category-item\"]//input[@id=\"categoryadult\"]/following-sibling::div//input[@id=\"adultQty\"]");

	public static final By SECOND_CLASS_LNK = By.xpath(
			"//div[@class=\"class-section__selector\"]//label[@class=\"option\" and @for=\"second-class-passtable\"]");

	public static final By ADD_TO_CART_LNK = By.xpath(
			"//div[@data-cy=\"pt-pass-title-3-days-within-1-month\"]//parent::div/following-sibling::div[@class=\"part part-b\"]/div/button[contains(text(),\"Add to cart\")]");

	public static final By CHECKOUT_BASKET_LNK = By
			.xpath("//div[@class=\"dialog-add-to-cart\"]//a[@href=\"/en/checkout/checkout-basket-review\"]");

	public static final By BASKET_REVIEW_CONTINUE_BTN = By.xpath("//a[@data-cy=\"ck-basket-review-continue-button\"]");

	public static final By LOGIN_HERE_LNK = By.xpath("//a[@data-cy=\"login-link\"]");

	public static final By LOGIN_EMAIL_TXTBOX = By
			.xpath("//div[@class=\"my-account\"]//input[@name=\"email\" and @type=\"email\"]");

	public static final By LOGIN_PWD_TXTBOX = By
			.xpath("//div[@class=\"my-account\"]//input[@name=\"password\" and @type=\"password\"]");

	public static final By LOGIN_ACCOUNT_BTN = By
			.xpath("//div[@class=\"my-account\"]//button[@data-cy=\"login-btn\" and @type=\"submit\"]");

	public static final By BILLING_FNAME_TXTBOX = By.xpath("//input[@id=\"billingAddressFirstName\"]");

	public static final By BILLING_LNAME_TXTBOX = By.xpath("//input[@id=\"billingAddressLastName\"]");

	public static final By BILLING_COUNTRY_DRPDOWN = By.xpath("//select[@id=\"billingAddressCountry\"]");

	public static final By BILLING_CITY_TXTBOX = By.xpath("//input[@id=\"billingAddressCity\"]");

	public static final By BILLING_POSTALCODE_TXTBOX = By.xpath("//input[@id=\"billingAddressPostalCode\"]");

	public static final By BILLING_STREET_TXTBOX = By.xpath("//input[@id=\"billingAddressStreetName\"]");

	public static final By BILLING_PHONE_TXTBOX = By.xpath("//input[@id=\"billingAddressPhoneNumber\"]");

	public static final By BILLING_ORDER_DETAILS_BTN = By.xpath("//a[@href=\".orderdetails\"]");

	public static final By TRAVELLER_DETAILS_GENDER_M = By.xpath(
			"//legend[contains(text(),\"Title\")]/parent::fieldset//input[@type=\"radio\" and @name=\"gender\" and @value=\"m\"]");

	public static final By TRAVELLER_DETAILS_FNAME_TXTBOX = By.xpath("//input[@name=\"travellerFirstName\"]");
	public static final By TRAVELLER_DETAILS_LNAME_TXTBOX = By.xpath("//input[@name=\"travellerLastName\"]");

}
