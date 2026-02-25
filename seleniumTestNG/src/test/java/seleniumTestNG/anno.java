package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class anno {
   WebDriver driver;
	@BeforeMethod
	public void setup(){
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.youtube.com");
	}
	
	
	@Test
	public void searchVideo() throws InterruptedException{
		
	
		Thread.sleep(1000);
		driver.findElement(By.name("search_query")).sendKeys("Forza Horizon 6");
		Thread.sleep(3000);
		driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.id("video-title")).click();
		Thread.sleep(10000);
		
				
	}
	
	@Test
	public void getTitle() throws InterruptedException {
	System.out.println("Requested Title : " + driver.getTitle());
	}
	
	
		@AfterMethod 
		public void endScript() throws InterruptedException {	
		Thread.sleep(3000);
		driver.close();
		}	
	
}
