package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	//1. String locator 
	
	private String emailID = "#input-email";
	private String password = "//input[@id='input-password']";
	private String clickLoginBtn = "input[value='Login']";
	private String forgotPassword = "div[class='form-group'] a";
	private String logoutButton = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. page Constructor 
	
		public LoginPage(Page page)
		{
			this.page=page;
		}
		
	//3. page action/method
		public String loginPageTitle()
		{
			return page.title();
		}
		public boolean isForgotPwdlinkExist()
		{
			return page.isVisible(forgotPassword);
		}
		
		public boolean loginWithValidCreds(String appEmail, String appPassword)
		{
			System.out.println("Email: "+appEmail +" Password: "+appPassword);
			page.fill(emailID, appEmail);
			page.fill(password, appPassword);
			page.click(clickLoginBtn);
			
			if(page.isVisible(logoutButton))
			{
				System.out.println("User is successfully logged in...");
				return true;
			}
			return false;
			
		}
	

}
