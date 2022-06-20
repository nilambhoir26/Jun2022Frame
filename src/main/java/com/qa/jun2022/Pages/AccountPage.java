package com.qa.jun2022.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.jun2022.Base.BasePage;
import com.qa.jun2022.Utils.Constants;
import com.qa.jun2022.Utils.ElementUtil;

public class AccountPage  extends BasePage{

	public WebDriver driver;
	ElementUtil eleUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By AccountBreadcrumb = By.xpath("(//ul[@class='breadcrumb']/li)[position()=2]");
	
	
	public String getAccountPgTitle() {
		//return driver.getTitle();
		return eleUtil.waitForTitlePresent(Constants.Account_Page_Title, Duration.ofSeconds(10));
		
	}
	
	public String getBreadcrumbDetails() {
		//return driver.findElement(AccountBreadcrumb).getText();
		return eleUtil.doGetText(AccountBreadcrumb);
	}
	
	
	
	
	
	
	
}
