package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Logout {

	static WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//button[@title = 'Log out of WordPress.com']")
	WebElement logoutButton;


	public Logout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void logoutAccount()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);


		wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
		//logoutButton.click();
	}
}
