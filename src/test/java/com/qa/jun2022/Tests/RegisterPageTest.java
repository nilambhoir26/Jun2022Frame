package com.qa.jun2022.Tests;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.jun2022.Base.BaseTest;
import com.qa.jun2022.Pages.RegisterPage;
import com.qa.jun2022.Utils.Constants;
import com.qa.jun2022.Utils.ExcelUtils;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void navigateToRegister(){
		Registerpg = Loginpg.goToRegistertaion();
	}
	
	
	@Test
	public void verify_title_of_RegisterPg() {
		String RegsiterPgTitle = Registerpg.getRegisterPgTitle();
		Assert.assertEquals(RegsiterPgTitle, Constants.Regsiter_Page_Title);
	}
	
	
	@DataProvider
	public Object[][]  getTestDatafor_Registration() {
		 return ExcelUtils.getExcelData(Constants.Registration_Sheet_Name);
	}
	
	
	@Test (dataProvider ="getTestDatafor_Registration")
	public void verifyRegsitration(String Firstname, String LastName, String Email, String Telephone, String Password, String ConfirmPswd, String Subscribe) {
		
			String SuccessText = Registerpg.doRegistration(Firstname, LastName, Email, Telephone, Password, ConfirmPswd, Subscribe);
		
			Assert.assertEquals(SuccessText, "Your Account Has Been Created!");
			System.out.println("Registration works properly");
		
	}
}
