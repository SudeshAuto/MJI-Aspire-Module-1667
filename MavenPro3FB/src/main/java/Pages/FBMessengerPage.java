package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBMessengerPage 
{
	// Variable declaration ---> WebElement declaration
	 
		 @FindBy (xpath = "//a[text()='Rooms']")
		 private WebElement rooms ;
		 
		 @FindBy (xpath = "//a[text()='Features']")
		 private WebElement features ;
		 
		 		 
		 
		 
	// Constructor ---> WebElement Initialization
		 
		 public FBMessengerPage(WebDriver driver) 
		 {		  
			 PageFactory.initElements(driver, this);
		 }
		 
		 
		 
		 
	//Method - Use of WebElement
		 
		 public void clickRooms() 
		 {		 
			 rooms.click();
		 }
		 
		 public void clickFeatures() 
		 {		  
			 features.click();
		 }
		 
}
