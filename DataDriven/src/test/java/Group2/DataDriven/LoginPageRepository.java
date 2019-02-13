package Group2.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageRepository 
{
	WebDriver driver;
	By username=By.id("userName");
	By password=By.id("password");
	By login=By.xpath("//input[@value='Login']");
	
	//We can write other elements for other fields
	public LoginPageRepository(WebDriver driver)
	{
		this.driver=driver;
	}
	public void typeusername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	public void typepassword(String passwd)
	{
		driver.findElement(password).sendKeys(passwd);
	}
	public void clicksign()
	{
		driver.findElement(login).click();
	}

}
