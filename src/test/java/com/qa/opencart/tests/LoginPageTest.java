package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest
{
	@Test(priority = 1)
	public void loginPageNavigationTest()
	{
		loginPage = homePage.navigateToLoginPage();
		String accountPageTitle= loginPage.loginPageTitle();
		System.out.println("Actual Login Page title is: "+accountPageTitle);
		Assert.assertEquals(accountPageTitle, AppConstants.Account_Page_Title);
		
	}
	@Test (priority = 2)
	public void loginWithvalidCreds() throws InterruptedException
	{
	
		loginPage.loginWithValidCreds(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String loginPageTitle= loginPage.loginPageTitle();
		
		Assert.assertEquals(loginPageTitle, AppConstants.Login_Page_Title);

	}

}
