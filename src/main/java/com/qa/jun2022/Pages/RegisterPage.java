package com.qa.jun2022.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.jun2022.Base.BasePage;
import com.qa.jun2022.Utils.Constants;
import com.qa.jun2022.Utils.ElementUtil;

public class RegisterPage extends BasePage{
	public WebDriver driver;
	public ElementUtil eleUtil;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By Firstname = By.name("firstname");
	By Lastname = By.name("lastname");
	By Email = By.name("email");
	By Telephone = By.name("telephone");
	By Password = By.name("password");
	By CofirmPswd = By.xpath("//input[@id ='input-confirm']");
	By SubscribeYes = By.xpath("//input[@name='newsletter'and @value='1']");
	By SubscribeNo = By.xpath("//input[@name='newsletter' and @value='0']");
	By AgreeTC = By.xpath("//input[@type='checkbox' and @value ='1']");
	By RegisterBtn = By.xpath("//input[@type='submit' ]");
	By AfterSuccessfulRegText = By.xpath("//h1[text()='Your Account Has Been Created!' ]");
	By Logoutbtn = By.xpath("//a[@class ='list-group-item'][position()=13]");
	By RegisterLink = By.xpath("//a[@class ='list-group-item'][position()=2]");
	
	
	public String getRegisterPgTitle() {
	 return eleUtil.waitForTitlePresent(Constants.Regsiter_Page_Title, Duration.ofSeconds(10));		
	}
	
	public String doRegistration(String Fname, String Lname, String email, String phone, String password, String confirmpswd, String Subscribe) {
		eleUtil.doSendKeys(Firstname, Fname);
		eleUtil.doSendKeys(Lastname, Lname);
		eleUtil.doSendKeys(Email, email);
		eleUtil.doSendKeys(Telephone, phone);
		eleUtil.doSendKeys(Password, password);
		eleUtil.doSendKeys(CofirmPswd, confirmpswd);
		
		if(Subscribe.equals("yes")) {
			eleUtil.doClick(SubscribeYes);
		} else {
			eleUtil.doClick(SubscribeNo);
		}
	
	   eleUtil.doClick(AgreeTC);
	   eleUtil.doClick(RegisterBtn);
	   String SuccessText = eleUtil.waitForElementPresent(AfterSuccessfulRegText, Duration.ofSeconds(10)).getText();
	   eleUtil.doClick(Logoutbtn);
	   eleUtil.doClick(RegisterLink);
	   
	  return SuccessText;
	
	   
}
}


