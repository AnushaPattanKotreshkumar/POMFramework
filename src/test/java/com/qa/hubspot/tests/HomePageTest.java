  
package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BasePage {
    WebDriver driver;
    Properties prop;
	
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

//	@BeforeClass
//	public void homeSetup() {
//		homePage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//	}

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		
		 loginPage = new LoginPage(driver);
		 
		 homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
//	@Test(priority = 3)
//	public void verifyHomePageTitle() {
//	String title = homePage.getHomePageTitle();
//		System.out.println("home page title is : " + title);
//		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title is not matched....");
//	}

//	@Test(priority = 1)
//	public void verifyHomePageHeader() throws InterruptedException {
//		Thread.sleep(3000);
//		String header = homePage.getHomePageHeaderText();
//		System.out.println("Home page header is : " + header);
//		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header is not present...");
//	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest() throws InterruptedException {
		Thread.sleep(3000);
		homePage.clickOnAccountMenu();
		
		Thread.sleep(3000);
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user is : " + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "logged in user is not matched...");
	}
	

}
	

