package com.qa.jun2022.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.jun2022.Pages.AccountPage;
import com.qa.jun2022.Pages.LoginPage;
import com.qa.jun2022.Pages.RegisterPage;
import com.qa.jun2022.Utils.ExcelUtils;

public class BaseTest {

	public BasePage basepg;
	public Properties prop;
	public WebDriver driver;
	public LoginPage Loginpg;
	public AccountPage Acctpg;
	public RegisterPage Registerpg;
	public ExcelUtils excelUtil;
	
	@BeforeTest
	public void setUp() {
		basepg = new BasePage();
		prop = basepg.InitProperties();
		String Browser = prop.getProperty("Browser");
		driver = basepg.init_Browser(Browser);
		driver.get(prop.getProperty("Url"));
		Loginpg = new LoginPage(driver);
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
