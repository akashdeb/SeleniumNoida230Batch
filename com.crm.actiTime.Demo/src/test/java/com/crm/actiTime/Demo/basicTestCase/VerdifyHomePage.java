package com.crm.actiTime.Demo.basicTestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.actiTime.Demo.POMRepository.HomePage;
import com.crm.actiTime.Demo.POMRepository.LoginPage;
import com.crm.actiTime.Demo.POMRepository.TaskPage;
import com.crm.actiTime.seleniumAfternoonBatch.genericUtility.BaseClass;
import com.crm.actiTime.seleniumAfternoonBatch.genericUtility.ExcelUtitlity;
import com.crm.actiTime.seleniumAfternoonBatch.genericUtility.JavaUtitlity;

public class VerdifyHomePage extends BaseClass {
	
	@Test
	public void verifyTitleOfHomePageTest() throws IOException, InterruptedException {
		
		int randomNo = jUtils.randomNumber(1000);
		String companyName = eUtils.getDataFromExcel("Sheet2", 3, 0);
		String expectedCustomerName = companyName+randomNo;
		String expectedTitle = eUtils.getDataFromExcel("Sheet2", 1, 0);
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		
		//Verifying Title of Home page
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title is verified");
		Reporter.log("Note: Test Case not Passed");
		
		HomePage home = new HomePage(driver);
		home.clickOnTaskButton();
		
		TaskPage task = new TaskPage(driver);
		task.addNewCustomer(expectedCustomerName, "This is the description");
		
		 String actualCutomerName = task.verifyCutomerName(expectedCustomerName);
		
		 Assert.assertEquals(actualCutomerName, expectedCustomerName);
		 System.out.println("Pass: Customer is verified");
		 
}
}