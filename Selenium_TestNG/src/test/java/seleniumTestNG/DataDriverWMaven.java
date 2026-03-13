package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverWMaven {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "loginInfo")
	public void TestLogin(String username ,String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
	
	@DataProvider(name="loginInfo")
	public Object[][] getData() throws Exception {
	    return ExcelData.getExcelData("C:\\Users\\roshn\\Downloads\\DataDriven.xlsx", "Sheet1"
	    );
	}
 
	
	
	@AfterMethod
	public void destroy() {
		driver.quit();
	}
	
//	
}   
