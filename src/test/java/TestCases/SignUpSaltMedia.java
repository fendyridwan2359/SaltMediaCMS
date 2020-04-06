/**
 * 
 */
package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.SeriesList;
import pages.SignUpSalt;

/**
 * @author fendyridwan
 *
 */
public class SignUpSaltMedia extends BaseWeb {
	
	//@Test
	public void login() throws InterruptedException
	{
		SignUpSalt su = PageFactory.initElements(driver, SignUpSalt.class);
		int i = 0;
		//for(i=1;i<=99;i++)
		//{
			//try {
			su.clickSignUpButton();
			su.typeName("test");
			su.typeEmail("test001@gmail.com");
			su.typePass("12345678");
			su.typeConfPass("12345678");
			su.clickNextButton();
			
			
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[4]/div/div/div/div/div[3]/div[2]/button"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/ul/li[2]/span"))).click().build().perform();
			
			driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/ul/li[5]")).click();
			driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/button[1]")).click();
			Thread.sleep(2000);
			System.out.println("running for user :"+i);
			
				
			
		//}
	}
	
	@Test
	public void readandwrite() throws IOException {
		//Get the excel file and create an input stream for excel
		 FileInputStream fis = new FileInputStream("agevalidation.xlsx");
		 
		 //load the input stream to a workbook object
		 //Use XSSF for (.xlsx) excel file and HSSF for (.xls) excel file
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 
		 //get the sheet from the workbook by index
		 XSSFSheet sheet = wb.getSheet("Age");
		 
		 //Count the total number of rows present in the sheet
		 int rowcount = sheet.getLastRowNum();
		 System.out.println(" Total number of rows present in the sheet : "+rowcount);
		 
		 //get column count present in the sheet
		 int colcount = sheet.getRow(1).getLastCellNum();
		 System.out.println(" Total number of columns present in the sheet : "+colcount);
		 
		 //get the data from sheet by iterating through cells
		 //by using for loop
		 for(int i = 1; i<=rowcount; i++)
		  {
			 XSSFCell cell = sheet.getRow(i).getCell(1);
			 String celltext="";
			 
			 //Get celltype values
			 if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			 {
				 celltext=cell.getStringCellValue();
			 }
			 else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			 {
				  celltext=String.valueOf(cell.getNumericCellValue());
			 }
			 else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			 {
				 celltext="";
			 }
			 System.out.println("masuk?");
		  //Check the age and set the Cell value into excel
			 if(Double.parseDouble(celltext)>=3)
			 {
				 sheet.getRow(i).getCell(2).setCellValue("Major");
				 System.out.println("masuk");
			 }
			 else
			 {
				 sheet.getRow(i).getCell(2).setCellValue("Minor");
				 System.out.println("enggak");
			 }
			 
		  }//End of for loop
		 
		 //close the file input stream
		 fis.close();
		 
System.out.println("dibawah close");
	//Open an excel to write the data into workbook
	FileOutputStream fos = new FileOutputStream("agevalidation.xlsx");
	
	//Write into workbook
	wb.write(fos);
	
	//close fileoutstream
	fos.close();
	}

}
