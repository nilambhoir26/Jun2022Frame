package com.qa.jun2022.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.jun2022.Base.BaseTest;
import com.qa.jun2022.Utils.Constants;

public class LoginPgTests extends BaseTest{
	
	
	@Test
	public void verifyTitleOfLoginPg() {
		
		String Title = Loginpg.getTitleOfLoginPg();
		Assert.assertEquals(Title, Constants.Login_Page_Title);
		System.out.println("Title of the Login Page is "+ Title);
	}

}
