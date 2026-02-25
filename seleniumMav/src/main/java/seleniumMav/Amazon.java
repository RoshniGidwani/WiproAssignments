package seleniumMav;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox"))
      .sendKeys("T shirts for women", Keys.ENTER);
           Thread.sleep(3000);
           
           
       driver.findElement(By.id("a-autoid-3-announce")).click();
       
        driver.findElement(By.xpath("//button[.//span[contains(text(),'Add to Cart')]]")).click();               
        Thread.sleep(1000);
        driver.findElement(By.id("a-autoid-93-announce")).click();
        Thread.sleep(4000);
        
        
        //STUDY TABLE
//        driver.findElement(By.id("twotabsearchtextbox"))
//              .sendKeys("study table", Keys.ENTER);
//        Thread.sleep(3000);
//      
//        driver.findElement(By.id("a-autoid-2-announce")).click();
//        driver.findElement(By.className("nav-cart-count")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("a-button-text")).click();
//        Thread.sleep(2000);
       
        
        driver.quit();
    }
}
