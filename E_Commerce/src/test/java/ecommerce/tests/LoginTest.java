package ecommerce.tests;

import ecommerce.pages.LoginPage;
import ecommerce.retry.RetryAnalyzer;
import ecommerce.utils.ScreenshotUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
    
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("=== Starting Login Test Suite ===");
    }

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com");
    }

    @Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
    public void loginTest(String username, String password, String expected) {

        driver.findElement(LoginPage.username).clear();
        driver.findElement(LoginPage.password).clear();

        driver.findElement(LoginPage.username).sendKeys(username);
        driver.findElement(LoginPage.password).sendKeys(password);
        driver.findElement(LoginPage.loginBtn).click();

        if (expected.equals("success")) {

            Assert.assertTrue(
                driver.findElement(LoginPage.inventory).isDisplayed(),
                " Login failed"
            );

        } else if (expected.equals("error")) {

            String error = driver.findElement(LoginPage.errorMsg).getText();
            Assert.assertTrue(error.toLowerCase().contains("do not match"));

        } else if (expected.equals("empty")) {

            String error = driver.findElement(LoginPage.errorMsg).getText();
            Assert.assertTrue(
                error.contains("Username is required") ||
                error.contains("Password is required")
            );
        }

       
//        Assert.assertTrue(false);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
            {"standard_user", "secret_sauce", "success"},
            {"standard_user", "wrong_pass", "error"},
            {"invalid_user", "secret_sauce", "error"},
            {"", "", "empty"}
        };
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        System.out.println("Test Status: " + result.getStatus());

      
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.capture(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("=== Test Execution Completed ===");
    }
}