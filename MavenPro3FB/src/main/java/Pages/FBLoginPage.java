package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage 
{
	 // Variable declaration ---> WebElement declaration
	 
		 @FindBy (xpath = "//input[@id='email']")
		 private WebElement emailorphone ;
		 
		 @FindBy (xpath = "//input[@id='pass']")
		 private WebElement password ;
		 
		 @FindBy (xpath = "//button[@name='login']")
		 private WebElement loginbutton ;
		 
		 @FindBy (xpath = "//a[text()='Forgotten password?']")
		 private WebElement forgotpass ;
		 
		 @FindBy (xpath = "//a[text()='Create New Account']")
		 private WebElement createnewacc ;
		 
		 @FindBy (xpath = "//a[text()='Messenger']")
		 private WebElement messenger ;
		 
	 
	 
	 
	 
	 // Constructor ---> WebElement Initialization
	 
		 public FBLoginPage(WebDriver driver) 
		 {		  
			 PageFactory.initElements(driver, this);
		 }
		 
	 
	 
	 
	 //Method - Use of WebElement
	 
		 public void sendEmailOrPhone() 
		 {		 
			 emailorphone.sendKeys("9404369512");
		 }
		 
		 public void sendPassword() 
		 {		  
			 password.sendKeys("Aa@1Aa@1");
		 }
		 
		 public void clickLogin() 
		 {		  
			 loginbutton.click();
		 }
		 
		 public void clickForgottenPassword() 
		 {		  
			 forgotpass.click();
		 }
		 
		 public void clickCreateNewAcc() 
		 {		  
			 createnewacc.click();
		 }
		
		 public void clickMessenger() 
		 {		  
			 messenger.click();
		 }

}
