package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{

//1. By Locators --Object Repository
	
	private WebDriver driver;
	
	By username = By.id("username");
	By password= By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By googleBtn = By.linkText("Sign in with Google");
	By ssoBtn = By.id("ssoBtn");
	
	//2. Create constructor of page class
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	} 
	
	//3. Page actions
	
	public String getLoginPageTitle() {
		 return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
		
	}
	
	public boolean verifyGoogleLoginBtn() {
		return driver.findElement(googleBtn).isDisplayed();
	}
	
	
	

	public String verifySSOLoginBtn() {
		
		 if(driver.findElement(ssoBtn).isDisplayed());
		 {
		 return driver.findElement(ssoBtn).getText();
		}
	}
	
	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);
	}
}


