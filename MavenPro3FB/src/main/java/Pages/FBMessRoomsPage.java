package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBMessRoomsPage 
{
	// Variable declaration ---> WebElement declaration
	 
			 @FindBy (xpath = "//a[text()=' Return to messenger.com ']")
			 private WebElement returntomess ;
			 
			 @FindBy (xpath = "//a[text()=' Visit our help center ']")
			 private WebElement visithelpcenter ;
			 
			 		 
			 
			 
	// Constructor ---> WebElement Initialization
			 
			 public FBMessRoomsPage(WebDriver driver) 
			 {		  
				 PageFactory.initElements(driver, this);
			 }
			 
			 
			 
			 
	//Method - Use of WebElement
			 
			 public void clickReturnToMessenger() 
			 {		 
				 returntomess.click();
			 }
			 
			 public void clickVisitHelpCenter() 
			 {		  
				 visithelpcenter.click();
			 }
			 

}
