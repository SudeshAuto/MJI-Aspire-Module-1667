package test;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.FBLoginPage;
import Pages.FBMessRoomsPage;
import Pages.FBMessengerPage;

public class TestNGClass2Copy 
{
	WebDriver driver;	
	FBLoginPage fBLoginPage;
	FBMessengerPage fBMessengerPage;
	FBMessRoomsPage fBMessRoomsPage;	
	
	@BeforeClass
	public void launchBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\VC Software Testing\\Libraries\\chromedriver.exe");
	driver = new ChromeDriver();           
	//driver.manage().window().maximize();    
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);			
	}
	
	@BeforeMethod
	public void getFacebookURL() 
	{
		driver.get("https://www.facebook.com/");   
		
		fBLoginPage = new FBLoginPage(driver);
		fBLoginPage.clickMessenger();
		
		fBMessengerPage = new FBMessengerPage(driver);
		fBMessengerPage.clickRooms();
	}
	
	
	@Test (priority = 1) //timeOut = 4000, dependsOnMethods = "verifyVisitToOurHelpCenter")
	public void test1verifyReturnToMessenger() 
	{
		fBMessRoomsPage = new FBMessRoomsPage(driver);
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
		
		Assert.fail();
	}
	
	@Test (dependsOnMethods = "test1verifyReturnToMessenger")
	public void test2verifyVisitToOurHelpCenter1() 
	{
		
		
		fBMessRoomsPage = new FBMessRoomsPage(driver);
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
		
		//Assert.fail();
	}
	
	@Test (dependsOnMethods = "test1verifyReturnToMessenger")
	public void test3verifyVisitToOurHelpCenter() 
	{
		
		
		fBMessRoomsPage = new FBMessRoomsPage(driver);
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
		
		//Assert.fail();
	}
	
	@AfterMethod
	public void logOutOfTheFacebook()
	{
		System.out.println("Logout...!!!");
	}
	
	@AfterClass
	public void closeBrowser()
	{		
		driver.quit();
	}
	
	

}
