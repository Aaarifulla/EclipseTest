package Group2.DataDriven;

//Program to print the data from excel (Xls)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DD2XLS {
  @Test
  public void f() throws IOException 
  {
	  String FilePath = "C:\\Aarifulla\\DataDrivenDemoShee_XLS.xls";
	  FileInputStream fls=new FileInputStream(FilePath);
	  HSSFWorkbook wb1=new HSSFWorkbook(fls);
	  
	  HSSFSheet sheet1=wb1.getSheetAt(0);
	  String data00=sheet1.getRow(0).getCell(0).getStringCellValue();
	  System.out.println(data00);
	  String data01=sheet1.getRow(0).getCell(1).getStringCellValue();
	  System.out.println(data01);
	  wb1.close();
  }
}