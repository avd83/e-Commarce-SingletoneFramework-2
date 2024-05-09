package com.qa.base;

import org.openqa.selenium.WebDriver;

public class PageDriver {

	private static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

	private static PageDriver instance=null;

	private PageDriver() {

	}

	public static PageDriver getInstance() {

		if (instance == null) {

			instance = new PageDriver();
		}
		return instance;
	}

	public void setDriver(WebDriver driver) {

		webdriver.set(driver);
	}

	public WebDriver getDriver() {

		return webdriver.get();
	}
}
