package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	By header = By.xpath("//*[@data-key='getting-started-ui.appHeaderTitle']");
	By accountName = By.className("user-info-name");
	By accountMenubtn = By.id("account-menu");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

//	public String getHomePageTitle() {
//		return driver.getTitle();
//	}
//	
//	public String getHomePageHeaderText() 
//	{
//		if(driver.findElement(header).isDisplayed())
//		{
//		return driver.findElement(header).getText();
//		}
//		return null;
//	}
	
//	
	public String getLoggedInUser() throws InterruptedException {
		Thread.sleep(4000);
		if(driver.findElement(accountName).isDisplayed()) 
		{
			return driver.findElement(accountName).getText();
		}	
	return null;
	}
	
	
	public void clickOnAccountMenu() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(accountMenubtn).click();
	}

}

