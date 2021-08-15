package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Common {
	
	WebDriver driver;
	
	public void setupBrowser(String browser,String url)
	{
		String currDir = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", currDir + "/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", currDir + "/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Valid browser was not provided, hence quitting the automation run");
			System.exit(0);
		}
		
		driver.manage().window().maximize();
		
		if(url != "")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
	public void login(String username,String password)
	{
		
	}
	
}


