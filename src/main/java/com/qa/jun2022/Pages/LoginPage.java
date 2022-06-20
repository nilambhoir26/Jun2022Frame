package com.qa.jun2022.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.jun2022.Base.BasePage;
import com.qa.jun2022.Utils.Constants;
import com.qa.jun2022.Utils.ElementUtil;

public class LoginPage extends BasePage {

	public WebDriver driver;
	ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
		eleUtil = new ElementUtil(driver);
	}
	
	 private By email = By.name("email");
	 private By password = By.name("password");
	 private By LoginBtn = By.xpath("//input[@type=\"submit\"]");
	 private By ForgotPswd = By.linkText("Forgotten Password");
	 private By RegisterLink = By.xpath("(//div[@class='list-group']/a)[position() =2]");
	 private By RegsiterPg = By.xpath("(//a[@class='list-group-item'])[position() =2]");
	 
	 public String getTitleOfLoginPg() {
		//return driver.getTitle(); 
		 return eleUtil.waitForTitlePresent(Constants.Login_Page_Title, Duration.ofSeconds(10));
	 }
	
	 public AccountPage getLogin(String Username, String Password) {
			/*
			 * driver.findElement(email).sendKeys(Username);
			 * driver.findElement(password).sendKeys(Password);
			 * driver.findElement(LoginBtn).click();
			 */
		 eleUtil.doSendKeys(email, Username);
		 eleUtil.doSendKeys(password, Password);
		 eleUtil.doClick(LoginBtn);
		return new AccountPage(driver);
	 }
	 
	 public boolean isForgotpswdLinkExist() {
		//return driver.findElement(ForgotPswd).isDisplayed();
		return eleUtil.doIsDisplayed(ForgotPswd);
	 }
	
	public RegisterPage goToRegistertaion() {
		eleUtil.doClick(RegisterLink);
		return new RegisterPage(driver);
	}
	
	
	
	
	
}
