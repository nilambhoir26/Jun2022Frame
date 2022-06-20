package com.qa.jun2022.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.jun2022.Base.BaseTest;
import com.qa.jun2022.Utils.Constants;

public class AccountPageTests  extends BaseTest{

	
	@BeforeClass
	public void AccountPgSetUp() {
	Acctpg = Loginpg.getLogin(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	
	@Test
	public void verifyTitleOfAcctPg() {
		String Title = Acctpg.getAccountPgTitle();
		Assert.assertEquals(Title, Constants.Account_Page_Title);
		System.out.println("Title of Home Page is "+ Title);
	}
	
	
}
