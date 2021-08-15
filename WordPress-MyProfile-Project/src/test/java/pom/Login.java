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

public class Login {

	static WebDriver driver;

	@CacheLookup
	@FindBy(id = "usernameOrEmail")
	WebElement email;

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	WebElement continueButton;

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(), 'Got it!')]")
	WebElement cookieButton;

	@CacheLookup
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement pass;

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(), 'Log In')]")
	WebElement logInButton;

	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void loginAccount(String username,String password)
	{

		Reporter.log("Username: "+ username);
		Reporter.log("Password: " + password);
		email.clear();
		email.sendKeys(username);

		continueButton.click();

		cookieButton.click();

		WebDriverWait wait = new WebDriverWait(driver,10);

		
		wait.until(ExpectedConditions.visibilityOf(pass)).sendKeys(password);
		//WebElement email = wait.until(ExpectedConditions.v

		//WebElement elem = driver.findElement(By.id("email"));
		//email.sendKeys("test@123.com");

		//pass.clear();
	   //pass.sendKeys(password);

		logInButton.click();

	}
}
