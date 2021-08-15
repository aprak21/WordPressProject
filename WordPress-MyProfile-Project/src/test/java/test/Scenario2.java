package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class Scenario2 extends Base 

{

	//*******  Update Profile Details: First Name, Last Name, public Display Name, About Me. Save changes. ******//
	
	
	MyProfilePage myPage;
	
	
	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}
	
	@Parameters("changeFirstName")
	@Test (priority = 1,groups = {"changeProfile"})
	public void updateFirstName(String fName) 
	{
		myPage.updateFirstName(fName);

	}
	
	@Parameters("changeLastName")
	@Test (priority = 2,groups = {"changeProfile"})
	public void updateLastName(String lName) 
	{
		myPage.updateLastName(lName);

	}
	
	@Parameters("changePublicDisplayName")
	@Test (priority = 3,groups = {"changeProfile"})
	public void updatePublicDisplayName(String pubDispName) 
	{
		myPage.updatePublicDisplayName(pubDispName);

	}
	
	@Parameters("changeAboutMe")
	@Test (priority = 4,groups = {"changeProfile"})
	public void updateAboutMe(String desc) 
	{
		myPage.updateAboutMe(desc);

	}
	
//	@Parameters("changeProfilePicture")
//	@Test (priority = 5,groups = {"changeProfile"})
//	public void updateProfilePicture(String profilePic) 
//	{
//		myPage.updateProfilePicture(profilePic);
//	}
	
	@Test (priority = 5,dependsOnMethods = {"updateFirstName","updateLastName","updatePublicDisplayName","updateAboutMe"})
	public void saveProfileUpdates() 
	{
		myPage.saveProfileDetails();
	}
	
	
	@Test (priority = 6)
	public void toggleGravatarProfile() 
	{
		//Turn on Gravatar Profile
		myPage.toggleGravatarButton();
		
		//Turn off Gravatar profile
		myPage.toggleGravatarButton();

	}
	
	
//	@Test (priority = 6, dependsOnMethods = {"saveProfileUpdates"})
//	public void AlertMessageAfterSaveProfile() 
//	{
//		myPage.verifyAlertAfterSave();
//		//Dismiss the Alert
//		myPage.dismissAlertAfterSave();
//	}
//	
}
