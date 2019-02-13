package Group2.DataDriven;


import org.testng.annotations.Test;

import junit.framework.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class DataProvider {
FileInputStream fls;
XSSFWorkbook wb;
XSSFSheet sh1;
WebDriver driver;
  @Test(dataProvider = "sampledata")
  public void f(String uid, String pwd) throws InterruptedException {
  System.setProperty("webdriver.chrome.driver", "C:\\testFeb\\Drivers\\chromedriver.exe");
  driver=new ChromeDriver();
    
  driver.get("http://10.188.144.28:8083/TestMeApp");
  Thread.sleep(4000);
  driver.manage().window().maximize();
  driver.findElement(By.linkText("SignIn")).click();
  driver.findElement(By.name("userName")).sendKeys(uid);
  driver.findElement(By.name("password")).sendKeys(pwd);
  driver.findElement(By.name("Login")).click();
  Thread.sleep(3000);
  Assert.assertEquals("Home", driver.getTitle());
  
  
  }
  @AfterMethod
    public void afterTest() {
  driver.close();
  }

  @Dataprovider(name="sampledata")
  public Object[][] TestData() throws IOException {
  File src= new File("C:\\testFeb\\data.xlsx");
  FileInputStream fls= new FileInputStream(src);
  XSSFWorkbook wb= new XSSFWorkbook(fls);
  sh1=wb.getSheetAt(0);
  
  int rows=sh1.getLastRowNum();
  
  int totalcnt=rows+1;
  Object[][] data= new Object[totalcnt][2];
  for(int i=1;i<totalcnt;i++) {
  data[i][0]=sh1.getRow(i).getCell(0).getStringCellValue();
  data[i][1]=sh1.getRow(i).getCell(1).getStringCellValue();
    
    
    }
return data;
       
  }
}

