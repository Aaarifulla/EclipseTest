package Group2.DataDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageRepositor {
  @Test
  public void f() throws InterruptedException 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Aarifulla\\Drivers\\Selenium_Softwares\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://10.188.144.28:8083/TestMeApp/login.htm");
	  LoginPageRepository loginobj = new LoginPageRepository(driver);
	  
	  loginobj.typeusername("admin");
	  loginobj.typepassword("password1234");
	  loginobj.clicksign();
	  Thread.sleep(3000);
	  
	  driver.quit();
  }
}
