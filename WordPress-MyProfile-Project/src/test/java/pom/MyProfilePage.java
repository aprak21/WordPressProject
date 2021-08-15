package pom;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyProfilePage {

	static WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//img[@alt = 'My Profile']")
	WebElement myProfilePage;

	@CacheLookup
	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement firstName;

	@CacheLookup
	@FindBy(id = "last_name")
	WebElement lastName;

	@CacheLookup
	@FindBy(id = "display_name")
	WebElement publicDisplayName;

	@CacheLookup
	@FindBy(id = "description")
	WebElement desc;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'animate__appear']/img")
	WebElement profilePicture;

	@CacheLookup
	@FindBy(xpath = "//button[@class = 'button form-button is-primary']")
	WebElement saveProfileDetailsButton;

	@CacheLookup
	@FindBy(xpath = "//span[@class = 'notice__text']")
	WebElement afterSaveAlertMessage;

	@CacheLookup
	@FindBy(xpath = "//button[@class = 'notice__dismiss']")
	WebElement afterSaveAlertDismiss;

	@CacheLookup
	@FindBy(xpath = "//input[@class='components-form-toggle__input']")
	WebElement toggleGravatar;
	
	
	@CacheLookup
	@FindBy(xpath = "//span[contains(text(), 'Add')]")
	WebElement addButton;
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(text(), 'Add WordPress Site')]")
	WebElement addWordPressSiteButton;
	
	@CacheLookup
	@FindBy(xpath = "//input[@class = 'profile-links-add-wordpress__checkbox form-checkbox']")
	WebElement addWordPressSite;
	
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Add Site')]")
	WebElement addWordPressSiteConfirmButton;
	
	@CacheLookup
	@FindBy(xpath = "//button[@class = 'button profile-link__remove is-borderless']")
	WebElement deleteWordPressSite;
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(text(), 'Add URL')]")
	WebElement addURLButton;
	
	
	@CacheLookup
	@FindBy(xpath = "//input[@class = 'form-text-input profile-links-add-other__value']")
	WebElement enterURL;
	
	@CacheLookup
	@FindBy(xpath = "//input[@class = 'form-text-input profile-links-add-other__title']")
	WebElement enterURLDescription;
	
	
	@CacheLookup
	@FindBy(xpath = "//button[@class = 'button profile-links-add-other__add form-button is-primary']")
	WebElement addURLConfirmButton;
	
	@CacheLookup
	@FindBy(xpath = "//button[@class = 'button profile-link__remove is-borderless']")
	WebElement deleteURL;
	
	@CacheLookup
	@FindBy(xpath = "//button[@class = 'info-popover edit-gravatar__pop-over']")
	WebElement infoTextButton;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class = 'popover__inner']")
	WebElement infoText;
	
	@CacheLookup
	@FindBy(partialLinkText = "Account Settings")
	WebElement accSettingsLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Purchases")
	WebElement purchasesLinkTextDisplay;
	
	
	@CacheLookup
	@FindBy(partialLinkText = "Security")
	WebElement securityLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Privacy")
	WebElement privacyLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Manage Blogs")
	WebElement manageBlogsLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Notification Settings")
	WebElement notifLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Blocked Sites")
	WebElement blockedSitesLinkTextDisplay;
	
	@CacheLookup
	@FindBy(partialLinkText = "Get Apps")
	WebElement getAppsLinkTextDisplay;
	
	
	public MyProfilePage(WebDriver driver)
	{
		//System.out.println("IN MY PROFILE PAGE");
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void clickMyProfile()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(myProfilePage));
		myProfilePage.click();
	}

	public void updateFirstName(String fName)
	{
		firstName.clear();
		firstName.sendKeys(fName);
	}

	public void updateLastName(String lName)
	{
		lastName.clear();
		lastName.sendKeys(lName);
	}

	public void updatePublicDisplayName(String pubDispName)
	{
		publicDisplayName.clear();
		publicDisplayName.sendKeys(pubDispName);
	}

	public void updateAboutMe(String abtMe)
	{
		desc.clear();
		desc.sendKeys(abtMe);
	}

//	public void updateProfilePicture(String testImage)
//	{
//		//WebElement elem = driver.findElement(By.xpath("//span[contains(@class,'edit-gravatar__label')]"));
//		
//		driver.findElement(By.linkText("Click to change photo")).sendKeys(testImage);
//
//		//JavascriptExecutor executor = (JavascriptExecutor)driver;
//		//	executor.executeScript("arguments[0].sendKeys(\"testImage.png\");\n"
//		//	+ "	;", elem);
//		//	
//	}
	
	public void saveProfileDetails()
	{
		saveProfileDetailsButton.click();
	}

	public void verifyAlertAfterSave()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(afterSaveAlertMessage));
		Reporter.log("THE ALERT MESSAGE AFTER SAVING THE PROFILE UPDATE: " + afterSaveAlertMessage.getText());
	}

	public void dismissAlertAfterSave()
	{
		afterSaveAlertDismiss.click();
	}

	public void getFirstName()
	{
		Reporter.log("FIRST NAME: " + firstName.getAttribute("value"));
	}

	public void getLastName()
	{
		Reporter.log("LAST NAME: " + lastName.getAttribute("value"));
	}

	public void getPublicDisplayName()
	{
		Reporter.log("PUBLIC DISPLAY NAME: " + publicDisplayName.getAttribute("value"));
	}

	public void getAboutMe()
	{
		Reporter.log("ABOUT ME: " + desc.getAttribute("value"));
	}

	public void getProfilePicture()
	{
		File src=((TakesScreenshot)profilePicture).getScreenshotAs(OutputType.FILE);

		File screenShotName= new File("/Users/anushaprashanth/eclipse-workspace/WordPress-MyProfile-Project/test-output/profileImage.jpg");

		try {
			FileHandler.copy(src, screenShotName );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("<br><img src='"+screenShotName+"' height ='200' width = '200'/><br>");

	}

	public void verifyElementDisplayFirstName()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);

		wait.until(ExpectedConditions.visibilityOf(firstName));
		assertTrue(firstName.isDisplayed());
	}

	public void verifyElementDisplayLastName()
	{
		assertTrue(lastName.isDisplayed());
	}

	public void verifyElementDisplayPublicDisplayName()
	{
		assertTrue(publicDisplayName.isDisplayed());
	}

	public void verifyElementDisplayAboutMe()
	{
		assertTrue(desc.isDisplayed());
	}

	public void verifyElementDisplayProfilePicture()
	{
		assertTrue(profilePicture.isDisplayed());
	}

	public void toggleGravatarButton()
	{
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(toggleGravatar));
		toggleGravatar.click();
	}

	public void clickAddProfileLink()
	{
		addButton.click();
	}

	public void addWordPressSite()
	{
		addWordPressSiteButton.click();
		addWordPressSite.click();
		addWordPressSiteConfirmButton.click();
	}
	
	public void addURL(String url, String desc)
	{
		addURLButton.click();
		
		enterURL.clear();
		enterURL.sendKeys(url);
		
		enterURLDescription.clear();
		enterURLDescription.sendKeys(desc);
		
		addURLConfirmButton.click();
	}

	public void deleteWordPressSite()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(deleteWordPressSite));
		deleteWordPressSite.click();
	}
	
	public void deleteURL()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(deleteURL));
		deleteURL.click();

	}

	public void profilePictureInfoTextVerification()
	{
		infoTextButton.click();
		Reporter.log("INFORMATION DISPLAYED: " + infoText.isDisplayed());

	}

	public void accountSettingsLinkTextVerification()
	{
		assertTrue(accSettingsLinkTextDisplay.isDisplayed());

	}
	
	public void purchasesLinkTextVerification()
	{
		assertTrue(purchasesLinkTextDisplay.isDisplayed());

	}
	
	public void securityLinkTextVerification()
	{
		assertTrue(securityLinkTextDisplay.isDisplayed());

	}
	
	public void privacyLinkTextVerification()
	{
		assertTrue(privacyLinkTextDisplay.isDisplayed());

	}
	
	public void manageBlogsLinkTextVerification()
	{
		assertTrue(manageBlogsLinkTextDisplay.isDisplayed());

	}
	
	public void notifSettingsLinkTextVerification()
	{
		assertTrue(notifLinkTextDisplay.isDisplayed());

	}

	public void blockedSitesLinkTextVerification()
	{
		assertTrue(blockedSitesLinkTextDisplay.isDisplayed());

	}
	
	public void getAppsLinkTextVerification()
	{
		assertTrue(getAppsLinkTextDisplay.isDisplayed());

	}
}
