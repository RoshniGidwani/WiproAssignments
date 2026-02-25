package webdriver_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class resume_upload{

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        
            driver.get("https://the-internet.herokuapp.com/upload");
            driver.manage().window().maximize();

       
            String filePath ="C:\\Users\\roshn\\OneDrive\\Desktop\\Resume.pdf";
            Thread.sleep(2000);
         
            WebElement fileInput = driver.findElement(By.id("file-upload"));
            Thread.sleep(4000);
     
            fileInput.sendKeys(filePath);

 
            driver.findElement(By.id("file-submit")).click();
            Thread.sleep(4000);
           
            String confirmation = driver.findElement(By.tagName("h3")).getText();
            System.out.println("Upload Status: " + confirmation);

         
            driver.quit();
        
    }
}
