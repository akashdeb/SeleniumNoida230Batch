package com.crm.actiTime.Demo.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
			}
	
	@FindBy (id = "container_tasks")
	private WebElement taskButton;
	
	public WebElement getTaskButton() {
		return taskButton;
	}

	@FindBy (id = "logoutLink")
	private WebElement logoutLink;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public void clickOnTaskButton() {
		taskButton.click();
	}
	
	public void logoutAction() {
		logoutLink.click();
	}
	
}
