package seleniumMav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login { 
	public static void main(String[] args)  throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		
	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("https://www.saucedemo.com/");
	     driver.findElement(By.name("user-name")).sendKeys("visual_user");
	     driver.findElement(By.id("password")).sendKeys("secret_sauce");
	     driver.findElement(By.id("login-button")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	     driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	     driver.findElement(By.className("shopping_cart_link")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.id("checkout")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.id("first-name")).sendKeys("Roshni");
	     driver.findElement(By.id("last-name")).sendKeys("Gidwani");
	     driver.findElement(By.id("postal-code")).sendKeys("nahi pata");
	     Thread.sleep(4000);
	     driver.findElement(By.id("continue")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.id("finish")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.id("back-to-products")).click();
	     Thread.sleep(2000);

	     driver.quit();
	}
}
