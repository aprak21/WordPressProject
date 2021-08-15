package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class Scenario5 extends Base 

{

	//*******  Link Text Display Verification ******//


	MyProfilePage myPage;


	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}


	@Test (priority = 1)
	public void accountSettingsLinkTextVerification() 
	{
		myPage.accountSettingsLinkTextVerification();

	}
	
	@Test (priority = 2)
	public void purchasesLinkTextVerification() 
	{
		myPage.purchasesLinkTextVerification();

	}
	
	@Test (priority = 3)
	public void securityLinkTextVerification() 
	{
		myPage.securityLinkTextVerification();

	}
	
	@Test (priority = 4)
	public void privacyLinkTextVerification() 
	{
		myPage.privacyLinkTextVerification();

	}

	@Test (priority = 5)
	public void manageBlogsLinkTextVerification() 
	{
		myPage.manageBlogsLinkTextVerification();

	}
	
	@Test (priority = 6)
	public void notifSettingsLinkTextVerification() 
	{
		myPage.notifSettingsLinkTextVerification();

	}
	
	@Test (priority = 7)
	public void blockedSitesLinkTextVerification() 
	{
		myPage.blockedSitesLinkTextVerification();

	}
	
	@Test (priority = 8)
	public void getAppsLinkTextVerification() 
	{
		myPage.getAppsLinkTextVerification();

	}
	
	
}
