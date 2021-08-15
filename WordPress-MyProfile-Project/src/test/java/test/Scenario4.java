package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class Scenario4 extends Base 

{

	//*******  Info Text Verification under the profile picture ******//


	MyProfilePage myPage;


	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}


	@Test (priority = 1)
	public void infoVerification() 
	{
		myPage.profilePictureInfoTextVerification();

	}

}
