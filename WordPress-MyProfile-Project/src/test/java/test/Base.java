package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pom.Login;
import pom.Logout;
import utils.Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
	Common common;
	Login login;
	Logout logout;
	static WebDriver driver;
	
	@Parameters({"browser","url","userName","password"})
	@BeforeTest
	public void beforeTest(String browser, String url, String username, String password) {

		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
		login = new Login(driver);
		login.loginAccount(username, password);
		
	}


	@AfterTest
	public void afterTest() 
	{
		logout = new Logout(driver);
		logout.logoutAccount();
		common.quitBrowser();

	}

}
