package com.crm.actiTime.seleniumAfternoonBatch.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.actiTime.Demo.POMRepository.HomePage;
import com.crm.actiTime.Demo.POMRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public JavaUtitlity jUtils = new JavaUtitlity();
	public LoginPage login = new LoginPage(driver);
	public ExcelUtitlity eUtils=new ExcelUtitlity();

	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("========Database connection is established=======");
	}
	@BeforeTest
	public void btConfig() {
		System.out.println("=======Parallel during cross browser execution is started=========");
	}
	@Parameters("browser")
	@BeforeClass
	public void bcConfig(String browser) throws IOException {
		
		System.out.println("Open The Browser "+browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		String url = jUtils.getDataFromPropertyFile("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);	
		}
	@BeforeMethod
	public void bmConfig() throws IOException {
		System.out.println("Login to the Application");
		//Login Action
		String username = jUtils.getDataFromPropertyFile("username");
		String password = jUtils.getDataFromPropertyFile("password");
		login.loginAction(username, password);
	}
	@AfterMethod
	public void amConfig() {
		System.out.println("Logout from the Apllication");
		HomePage home = new HomePage(driver);
		home.logoutAction();
	}
	@AfterClass
	public void acConfig() {
		System.out.println("Quit the browser");
		driver.quit();
	}
	@AfterTest
	public void atConfig() {
		System.out.println("=======Parallel during cross browser execution is done=========");

	}
	@AfterSuite
	public void asConfig() {
		System.out.println("========Database connection is closed=======");

	}
	
	
}
