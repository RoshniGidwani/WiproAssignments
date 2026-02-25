package seleniumMav;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class yahoo_login{

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       

        driver.manage().window().maximize();
        driver.get("https://mail.yahoo.com/n/folders/1?.src=ym&reason=myc");

        driver.findElement(By.id("login-username"))
                .sendKeys("roshni.any4@yahoo.com");

        driver.findElement(By.id("login-signin")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("login-passwd"))
                .sendKeys("Monkey@2003");

        driver.findElement(By.id("login-signin")).click();

        Thread.sleep(15000);

        driver.close();
    }
}