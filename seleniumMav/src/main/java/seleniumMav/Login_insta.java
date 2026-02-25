package seleniumMav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_insta {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       

        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/accounts/login/?hl=en");
        
        driver.findElement(By.id("_r_6_"))
        .sendKeys("makeitri8");
        
        driver.findElement(By.id("_r_9_"))
        .sendKeys("");
        
        
        driver.findElement(By.id("login-signin")).click();
        
        driver.close();
	}

}
