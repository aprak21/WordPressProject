package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.MyProfilePage;

public class Scenario3 extends Base 

{

	//*******  Add and Delete Profile Link ******//
	//*******  Add and Delete URL ******//


	MyProfilePage myPage;


	@BeforeClass
	public void beforeClass()
	{
		myPage = new MyProfilePage(driver);
		myPage.clickMyProfile();
	}


	@Test (priority = 1)
	public void addWordPressSite() 
	{
		myPage.clickAddProfileLink();
		myPage.addWordPressSite();

		//		try {
		//			Thread.sleep(15000);
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

	}

	@Test (priority = 2,dependsOnMethods = {"addWordPressSite"})
	public void deleteWordPressSite() 
	{
		myPage.deleteWordPressSite();
	}

	@Parameters({"addURL","urlDescription"})
	@Test (priority = 3)
	public void addURL(String url, String desc) 
	{
		myPage.clickAddProfileLink();
		myPage.addURL(url,desc);
	}

	@Test (priority = 4,dependsOnMethods = {"addURL"})
	public void deleteURL() 
	{
		myPage.deleteURL();
	}

}
