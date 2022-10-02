package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browsers.Base;
import Browsers.Base;
import Pages.FBLoginPage;
import Pages.FBMessRoomsPage;
import Pages.FBMessengerPage;
import utils.Utility;

public class TestNGClass2 extends Base
{
	WebDriver driver;	
	FBLoginPage fBLoginPage;
	FBMessengerPage fBMessengerPage;
	FBMessRoomsPage fBMessRoomsPage;
	SoftAssert soft;
	int testID;
	
//@Parameters("browser")
@BeforeTest
	public void launchBrowser()
	{
		driver = openChromeBrowser();
//		if(browserName.equals("Chrome"))
//		{
//			driver = openChromeBrowser();
//		}
//	
//		if(browserName.equals("Edge"))
//		{
//			driver = openEdgeBrowser();
//		}
	}
	
@BeforeClass
	public void creatingPOMObjects()
	{
		fBLoginPage = new FBLoginPage(driver);
		fBMessengerPage = new FBMessengerPage(driver);
		fBMessRoomsPage = new FBMessRoomsPage(driver);
	}
	
@BeforeMethod
	public void goToRoomsPage() 
	{
		driver.get("https://www.facebook.com/"); 
//		LogIn here if required.
		fBLoginPage.clickMessenger();		
		fBMessengerPage.clickRooms();
		soft = new SoftAssert();
	}
	
	
@Test (priority = 1, enabled= false) //timeOut = 4000, dependsOnMethods = "verifyVisitToOurHelpCenter")
	public void verifyRTM() 
	{
		testID = 132;
		fBMessRoomsPage.clickReturnToMessenger();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.messenger.com/") && title.equals("Messenger"))
		{
			System.out.println("Pass 111");
		}
		else
		{
			System.out.println("Fail 111");
			Assert.fail();
		}
	}
	
@Test (priority = 2)
	public void verifyVHC() throws IOException 
	{		
		testID = 133; 
		fBMessRoomsPage.clickVisitHelpCenter();			
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre"))
		{
			System.out.println("Pass 222");
		}
		else
		{
			System.out.println("Fail 222");
		}
		
		//Screenshot...
		Utility.captureScreenshot(driver, testID);
		System.out.println(Utility.excelData("Velocity", 5, 1));
		
		
//		Assert.fail();
		
	}
	
@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		System.out.println("Logout...!!!");
	}
	
@AfterClass
	public void removeObjects()
	{		
		fBLoginPage = null;
		fBMessengerPage = null;
		fBMessRoomsPage = null;
	}
	
@AfterTest
	public void closeBrowser()
	{
		System.out.println("After Class");
		driver.quit();
		driver = null;
		System.gc();	//Garbage collector = clears all null memory locations.
	}


}
