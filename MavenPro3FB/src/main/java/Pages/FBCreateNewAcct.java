package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FBCreateNewAcct 
{
	
	 Select s;
	
	 @FindBy (xpath = "//input[@name='firstname']")
	 private WebElement firstname ;
	 
	 @FindBy (xpath = "//input[@name='lastname']")
	 private WebElement lastname ;
	 
	 @FindBy (xpath = "//select[@id='day']")
	 private WebElement day ;
	 
	
	
	 public FBCreateNewAcct(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void sendFirstName(String str)
	 {
		 firstname.sendKeys(str);
	 }
	
	 public void sendLastName(String str)
	 {
		 lastname.sendKeys(str);
	 }
	 
	 public void selectDay(String str)
	 {
		s = new Select(day);
		s.selectByVisibleText(str);
	 }

	
}
