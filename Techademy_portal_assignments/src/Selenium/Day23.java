package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Day23 {

    @Test
    public void handleAdvancedControls() {

        WebDriver driver = null;
        WebDriverWait wait = null;

        try {

            // ===============================
            // 1️ Browser Setup
            // ===============================
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ===============================
            // 2️ JavaScript Alert Handling
            // ===============================
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            WebElement alertBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[text()='Click for JS Alert']")
                    )
            );
            alertBtn.click();

            // Wait and capture alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Validate alert text
            String expectedAlertText = "I am a JS Alert";
            String actualAlertText = alert.getText();

            Assert.assertEquals(actualAlertText, expectedAlertText,
                    "Alert text does not match!");

            // Accept alert
            alert.accept();

            System.out.println("Alert validated and accepted successfully.");

            // ===============================
            // 3️ Window Handling
            // ===============================
            driver.get("https://the-internet.herokuapp.com/windows");

            String parentWindow = driver.getWindowHandle();

            WebElement clickHere = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.linkText("Click Here")
                    )
            );
            clickHere.click();

            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            // Validate new window title
            String expectedTitle = "New Window";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, expectedTitle,
                    "Window title does not match!");

            System.out.println("Window title validated successfully.");

            // ===============================
            // 4️ Iframe Handling
            // ===============================
            driver.get("https://the-internet.herokuapp.com/iframe");

            wait.until(
                    ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr")
            );

            WebElement editor = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("tinymce")
                    )
            );

            String text = editor.getText();
            String expectedText = "Your content goes here.";

            Assert.assertEquals(text.trim(), expectedText,
                    "Iframe text does not match!");

            System.out.println("Iframe text validated successfully.");

            driver.switchTo().defaultContent();

        } catch (Exception e) {

            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();

        } finally {

            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully.");
            }
        }
    }
}


