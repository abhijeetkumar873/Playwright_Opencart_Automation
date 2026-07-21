package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencard.Factory.PlaywrightFactroy;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	PlaywrightFactroy pf;
	Page page;
	
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	
	@Parameters({ "browser" })
	
	@BeforeMethod

	public void setUp(String browserName)
	{
		pf = new PlaywrightFactroy();
		prop = pf.init_Prop();
		
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//page.context().browser().close();
	}


}
