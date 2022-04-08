package UtilityAndBase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class Utility {
	
	static Sheet Mysheet;
	
	public static String readDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream Myfile=new FileInputStream("C:\\Users\\mvkol\\Desktop\\Software Testing\\Yogendra sir java\\Selenium - Copy\\Book1.xlsx");
	    Mysheet = WorkbookFactory.create(Myfile).getSheet("Sheet5"); 
	    String value = Mysheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	public static void takeScreenShoot(WebDriver driver,int tcid) throws IOException
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desti=new File("C:\\Users\\mvkol\\Desktop\\Software Testing\\Yogendra sir java\\Selenium - Copy\\selenium study do\\Screenshots\\Sreen1"+tcid+".jpg");
		FileHandler.copy(src, desti);
		Reporter.log("screenshot taken for TC " +tcid,true); 
		
		
	}
	
	
	public static void myname()
	{
		System.out.println("code changed");
	}
	
	

}
