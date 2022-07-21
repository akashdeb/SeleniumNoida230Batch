package com.crm.actiTime.Demo.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	@FindBy (id = "username")
	private WebElement usernameTxtField;
	
	@FindBy (name = "pwd")
	private WebElement passwordTxtField;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement loginButton;

	@FindBy (id = "keepLoggedInCheckBox")
	private WebElement keepMeLoggedCheckBox;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTxtField() {
		return usernameTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Logic
	public void loginAction(String username, String password) {
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		keepMeLoggedCheckBox.click();
		loginButton.click();
	}
	
	
	
	
	
	

}
