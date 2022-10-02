package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.FBLoginPage;
import Pages.FBMessRoomsPage;
import Pages.FBMessengerPage;

public class VerifyVisitToOurHelpCenter 
{
	public static void main(String [] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VC Software Testing\\Libraries\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();           
		driver.manage().window().maximize();                    
		driver.get("https://www.facebook.com/");                 Thread.sleep(1000);		
	
		FBLoginPage fBLoginPage = new FBLoginPage(driver);
		fBLoginPage.clickMessenger();
		
		FBMessengerPage fBMessengerPage = new FBMessengerPage(driver);
		fBMessengerPage.clickRooms();
		
		FBMessRoomsPage fBMessRoomsPage = new FBMessRoomsPage(driver);
		fBMessRoomsPage.clickVisitHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre"))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		
		
		Thread.sleep(10000);
		driver.quit();	
	}

}
