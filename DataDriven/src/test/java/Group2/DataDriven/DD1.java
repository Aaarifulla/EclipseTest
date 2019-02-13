package Group2.DataDriven;

//Program to print the data from excel (Xlsx)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DD1 {
  @Test
  
  public void f() throws IOException, InterruptedException 
  {
	  
	  String FilePath = "C:\\Aarifulla\\DataDrivenDemoSheet_XLSX.xlsx";
	  FileInputStream fls=new FileInputStream(FilePath);
	  XSSFWorkbook wb1=new XSSFWorkbook(fls);	  
	  XSSFSheet sh1=wb1.getSheetAt(0);
	  
	  int rowCount=sh1.getLastRowNum();
	  rowCount = rowCount + 1;
	  
	  //System.out.println("Row Count"+rowCount);
	  System.setProperty("webdriver.chrome.driver","C:\\Aarifulla\\Drivers\\Selenium_Softwares\\chromedriver.exe\\");
		WebDriver driver=new ChromeDriver();		
		driver.get("http://10.188.144.28:8083/TestMeApp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("SignIn")).click();
	  for (int i=0; i<rowCount;i++)
	  {
		  String uid=sh1.getRow(i).getCell(0).getStringCellValue();
		  String pwd=sh1.getRow(i).getCell(1).getStringCellValue(); 	  
	   
		    driver.findElement(By.name("userName")).sendKeys(uid);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.name("Login")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
			Thread.sleep(10000);
	  
	  }
	driver.close();
	wb1.close();
	  
	  //TestLogin.testLoginMethod(luid, lpwd); 
		
		
	  //TestLogin.testLoginMethod(String luid, String lpwd);
	  //String data00=sheet1.getRow(0).getCell(0).getStringCellValue();
	  //System.out.println(data00);
	  //String data01=sheet1.getRow(0).getCell(1).getStringCellValue();
	  //System.out.println(data01);
	  
	  
	  
  }
  
}
