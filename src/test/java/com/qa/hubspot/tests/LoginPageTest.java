package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ConstantsUtil;

public class LoginPageTest {

	
	WebDriver driver;
	
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		 loginPage = new LoginPage(driver);
		 
	}
	

	@Test(priority = 1)
	public void verifySignUpLink()   {
		
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed....");
	}
	
	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
	System.out.println("login page title is " + title);
	Assert.assertEquals(title, ConstantsUtil.LOGIN_PAGE_TITLE, "Login page Title is not matched...");;
	}
	
	@Test(priority = 3)
	public void verifyGooglebtnTest() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(loginPage.verifyGoogleLoginBtn(), "Google btn is not displayed...");
	}
	
	@Test(priority = 4)
	public void verifySSOBtnTest() throws InterruptedException {
		Thread.sleep(3000);
		String ssoText1 = loginPage.verifySSOLoginBtn();
		System.out.println("SSO button text is: " + ssoText1);
		
		Assert.assertEquals(ssoText1, "Log in with SSO", "SSO btn is not displayed...");
	}
	
	@Test(priority = 5)
	public void LoginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
	}

