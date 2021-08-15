package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class resetProfile extends Base 

{

	//*******  RESET PROFILE   *******//
	
	MyProfilePage myPage;
	
	
	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}
	
	
	@Parameters({"resetFirstName","resetLastName","resetPublicDisplayName","resetAboutMe","resetProfilePic"})
//	@Test (dependsOnMethods = {"updateFirstName","updateLastName","updatePublicDisplayName","updateAboutMe","updateProfilePicture"}, priority = 6)
	@Test(priority = 1, enabled = true)
	public void resetProfileDetails(String fName, String lName, String pubDispName, String desc, String profilePic)
	{
		myPage.updateFirstName(fName);
		myPage.updateLastName(lName);
		myPage.updatePublicDisplayName(pubDispName);
		myPage.updateAboutMe(desc);
		//myPage.updateProfilePicture(profilePic);
		myPage.saveProfileDetails();
		
	}
	
}
