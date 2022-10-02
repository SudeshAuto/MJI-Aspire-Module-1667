package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static void captureScreenshot(WebDriver driver, int testNo) throws IOException
	{
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
		String dateAndTime = sdf.format(d);		
			
		File dst = new File("C:\\Users\\$11\\Desktop\\123\\TestID -"+testNo+" - "+dateAndTime+".jpg");
		
		FileHandler.copy(src, dst);
		
	}
	
	public static String excelData(String shName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		String strData;
		double numData;
		
		String path = "D:\\VC Software Testing\\Libraries\\Excel1.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(file);
		
		try 
		{
			strData = wb.getSheet(shName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		}		
		catch(IllegalStateException e)
		{
			numData = wb.getSheet(shName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
			strData = String.valueOf(numData);
		}
		
		return strData;
	}
}
















