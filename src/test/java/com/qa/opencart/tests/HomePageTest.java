package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest {
	
	@Test
	public void homePageTitleTest()
	{
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.Home_Page_Title, "Result Pass");
	}
	
	@Test
	public void homePageTitleURL()
	{
		String actURL = homePage.getHomePageURL();
		Assert.assertEquals(actURL, prop.getProperty("url"), "Result Pass");
	}
	
	@DataProvider
	
	public Object[][] getProductData() {
		return new Object [][]
				{
			{"macbook"},
			{"samsung"},
			{"IMAC"}
			
				};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String poductName)
	{
		String actualHeader= homePage.doSearch(poductName);
		Assert.assertEquals(actualHeader, "Search - "+poductName);
	}

}
