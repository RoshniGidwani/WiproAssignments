package selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class Day25 {

    @Parameters("browser")
    @Test
    public void gridTest(String browser) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setPlatform(Platform.WINDOWS);

        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                capabilities
        );

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Google"),
                "Title does not contain Google");

        driver.quit();
    }
}