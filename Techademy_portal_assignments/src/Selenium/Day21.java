package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day21 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to login page
        driver.get("https://the-internet.herokuapp.com/login");

        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyValidLogin() {

        // Enter username using By.id
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                .sendKeys("tomsmith");

        // Enter password using By.name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("SuperSecretPassword!");

        // Click login button using By.xpath
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']")))
                .click();

        // Capture success message
        String successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash")))
                .getText();

        // Validate success message
        Assert.assertTrue(
                successMessage.contains("You logged into a secure area"),
                "Login failed - Success message not found"
        );
    }

    @AfterMethod
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}


