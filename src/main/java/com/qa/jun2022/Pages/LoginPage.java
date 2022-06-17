package com.qa.jun2022.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.jun2022.Base.BasePage;

public class LoginPage extends BasePage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	 private By email = By.name("email");
	 private By password = By.name("password");
	 private By LoginBtn = By.xpath("//input[@type=\"submit\"]");
	 private By ForgotPswd = By.linkText("Forgotten Password");
	 
	 public String getTitleOfLoginPg() {
		return driver.getTitle(); 
	 }
	
	 public AccountPage getLogin(String Username, String Password) {
		driver.findElement(email).sendKeys(Username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(LoginBtn).click();
		return new AccountPage(driver);
	 }
	 
	 public boolean isForgotpswdLinkExist() {
		return driver.findElement(ForgotPswd).isDisplayed();
	 }
	
	
	
	
	
	
	
	
}
