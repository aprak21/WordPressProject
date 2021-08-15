package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class Scenario1 extends Base 

{

	//*******  Verification of elements display on 'My Profile' page and Display of the element values in the Test Report. ******//
	
	MyProfilePage myPage;
	
	
	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}
	
	@Test (priority = 1)
	public void verifyAndGetFirstName() 
	{
		myPage.verifyElementDisplayFirstName();
		
		myPage.getFirstName();
	}
	
	@Test (priority = 2)
	public void verifyAndGetLastName() 
	{
		myPage.verifyElementDisplayLastName();
		
		myPage.getLastName();
	}
	
	
	@Test (priority = 3)
	public void verifyAndGetPublicDisplayName() 
	{
		myPage.verifyElementDisplayPublicDisplayName();
		
		myPage.getPublicDisplayName();
	}
	
	
	@Test (priority = 4)
	public void verifyAndGetAboutMe() 
	{
		myPage.verifyElementDisplayAboutMe();
		
		myPage.getAboutMe();
	}
	
	@Test (priority = 5)
	public void verifyAndGetProfilePicture() 
	{
		myPage.verifyElementDisplayFirstName();
		
		myPage.getProfilePicture();
	}
	
}
