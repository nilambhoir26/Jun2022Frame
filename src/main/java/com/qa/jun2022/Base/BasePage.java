package com.qa.jun2022.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Neelam
 *
 */

public class BasePage {	
	
	public WebDriver driver;
	public Properties prop;
	/**
	 * 
	 * @param Here we are initilaizing browser
	 * @return Driver
	 */
	
	@SuppressWarnings("deprecation")
	public WebDriver init_Browser(String Browser) {

		System.out.println("Selected Browser is" + Browser);

		if (Browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please check your Browser details");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
	
	/**
	 * 
	 * @return Properties
	 */
	
	public Properties InitProperties() {
		
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(".//src//main//java//com//qa//jun2022//Config//config.Properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
		
		
		
	}
	
	
	
	
	
	
	
	

}
