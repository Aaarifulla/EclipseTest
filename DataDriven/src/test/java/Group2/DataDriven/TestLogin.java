package Group2.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin 
{
	public static void testLoginMethod(String luid, String lpwd) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Aarifulla\\Drivers\\Selenium_Softwares\\chromedriver.exe\\");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.188.144.28:8083/TestMeApp");
		Thread.sleep(3000);
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys(luid);
		driver.findElement(By.name("password")).sendKeys(lpwd);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
