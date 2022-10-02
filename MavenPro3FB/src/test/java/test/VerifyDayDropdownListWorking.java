package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.FBCreateNewAcct;
import Pages.FBLoginPage;

public class VerifyDayDropdownListWorking 
{
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VC Software Testing\\Libraries\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();           
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();                    
		driver.get("https://www.facebook.com/");                
		
		FBLoginPage fBLoginPage = new FBLoginPage(driver);
		fBLoginPage.clickCreateNewAcc();
		
		FBCreateNewAcct fBCreateNewAcct = new FBCreateNewAcct(driver);
		fBCreateNewAcct.sendFirstName("Sudesh");
		fBCreateNewAcct.sendLastName("Landge");
		fBCreateNewAcct.selectDay("5");
		
		System.out.println("Program done!");
		Thread.sleep(5000);
		driver.quit();
	}

}
