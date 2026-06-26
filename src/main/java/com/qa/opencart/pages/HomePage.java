package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage 
{
	private Page page;
	
	//1. String Locator - OR
	
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String accountLink = "span:text('My Account')";
	private String loginLink = "a:text('Login')";
	private String signUpLink ="//a[@text=('Register')]";
	
	//2. page Constructor 
	
	public HomePage(Page page)
	{
		this.page=page;
	}
	
	//3. page action/method
	
	public String getHomePageTitle()
	{
		String title= page.title();
		System.out.println("Page title: "+title);
		return title;
	}
	
	public String getHomePageURL()
	{
		String url= page.url();
		System.out.println("URL is: "+url);
		return url;
	}
	
	public String doSearch(String productName)
	{
		page.fill(search, productName);
		page.click(searchIcon);
		String headerText = page.textContent(searchPageHeader);
		System.out.println("Search Header: "+headerText);
		return headerText;
	}
	
	public LoginPage navigateToLoginPage()
	{
		page.click(accountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	
	public SignUpPage navigateToSignUpPage()
	{
		page.click(loginLink);
		return new SignUpPage();
	}

}
