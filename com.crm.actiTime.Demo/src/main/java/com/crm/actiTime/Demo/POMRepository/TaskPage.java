package com.crm.actiTime.Demo.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	WebDriver driver;
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[text()='Add New']" )
	private WebElement addNewButton;
	
	@FindBy(xpath = "//div[text()='+ New Customer']" )
	private WebElement newCustomerButton;
	
	@FindBy(xpath = "//input[@class=\"inputFieldWithPlaceholder newNameField inputNameField\"]" )
	private WebElement enterCustomerName;
	
	@FindBy(xpath = "//textarea[@placeholder=\"Enter Customer Description\"]")
	private WebElement descriptionTextArea;
	
	@FindBy (xpath = "//div[text()='- Select Customer -']")
	private WebElement selectCustomerDropdown;
	
	@FindBy (xpath = "//div[text()='- Select Customer -']/parent::div/descendant::div[text()='Big Bang Company']")
	private WebElement bigBangCompanyOption;
	
	@FindBy (xpath = "//div[text()='Create Customer']")
	private WebElement creatCustomerButton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getNewCustomerButton() {
		return newCustomerButton;
	}

	public WebElement getEnterCustomerName() {
		return enterCustomerName;
	}

	public WebElement getDescriptionTextArea() {
		return descriptionTextArea;
	}

	public WebElement getSelectCustomerDropdown() {
		return selectCustomerDropdown;
	}

	public WebElement getBigBangCompanyOption() {
		return bigBangCompanyOption;
	}

	public WebElement getCreatCustomerButton() {
		return creatCustomerButton;
	}
	
	public void addNewCustomer(String customerName, String description) {
		addNewButton.click();
		newCustomerButton.click();
		enterCustomerName.sendKeys(customerName);
		descriptionTextArea.sendKeys(description);
		selectCustomerDropdown.click();
		bigBangCompanyOption.click();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		creatCustomerButton.click();
	}
	
	public String verifyCutomerName(String expectedCustomerName) {
		String customerNameText = driver.findElement(By.xpath("(//div[text()='"+expectedCustomerName+"'])[2]")).getText();
		return customerNameText;
	}
}
