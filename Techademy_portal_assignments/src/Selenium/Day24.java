package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton   = By.cssSelector("button[type='submit']");
    By messageText   = By.id("flash");

    public void login(String username, String password) {

        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public String getMessage() {
        return driver.findElement(messageText).getText();
    }
}

public class Day24 {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!"},
                {"wrongUser", "wrongPass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String user, String pass) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            LoginPage loginPage = new LoginPage(driver);

            loginPage.login(user, pass);

            String message = loginPage.getMessage();

            if (user.equals("tomsmith") && pass.equals("SuperSecretPassword!")) {
                Assert.assertTrue(message.contains("You logged into a secure area!"));
            } else {
                Assert.assertTrue(message.contains("Your username is invalid!"));
            }

        } finally {
            driver.quit();
        }
    }
}