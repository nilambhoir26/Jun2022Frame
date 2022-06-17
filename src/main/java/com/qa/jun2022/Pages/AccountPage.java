package com.qa.jun2022.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.jun2022.Base.BasePage;

public class AccountPage  extends BasePage{

	public WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AccountBreadcrumb = By.xpath("(//ul[@class='breadcrumb']/li)[position()=2]");
	
	
	public String getAccountPgTitle() {
		return driver.getTitle();
	}
	
	public String getBreadcrumbDetails() {
		return driver.findElement(AccountBreadcrumb).getText();
	}
	
	
	
	
	
	
	
}
