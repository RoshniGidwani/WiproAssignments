package seleniumMav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmail_login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://accounts.google.com/");
	        
	        driver.findElement(By.id("identifierId"))
            .sendKeys("roshni.any4@gmail.com");
	       
	        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
	        
	        Thread.sleep(5000);

	        
	        
	        
	        driver.close();
	}

}
