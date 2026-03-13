package Cucumber;

import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Day30 {

    public static void main(String[] args) throws Exception {

        String feature =
                "Feature: Login functionality\n" +
                "Background:\n" +
                "Given user is on login page\n" +
                "\n" +
                "Scenario Outline: Login validation\n" +
                "When user enters username \"<username>\" and password \"<password>\"\n" +
                "And user clicks on login button\n" +
                "Then login should be \"<result>\"\n" +
                "\n" +
                "Examples:\n" +
                "| username | password | result |\n" +
                "| admin | admin123 | successful |\n" +
                "| user | wrong123 | unsuccessful |\n" +
                "\n" +
                "Scenario: Login using data table\n" +
                "When user logs in with following credentials\n" +
                "| username | password |\n" +
                "| admin | admin123 |\n" +
                "| user | wrong123 |";

        Files.write(Paths.get("login.feature"), feature.getBytes());

        JUnitCore.runClasses(Runner.class);
    }

    public static WebDriver driver;
    public static String loginResult;

    public static class Steps {

        @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

        @After
        public void tearDown() {
            driver.quit();
        }

        @Given("user is on login page")
        public void openLoginPage() {
            driver.get("https://example.com/login");
        }

        @When("user enters username {string} and password {string}")
        public void enterCredentials(String username, String password) {
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
        }

        @When("user clicks on login button")
        public void clickLogin() {
            driver.findElement(By.id("login")).click();
            if (driver.getPageSource().contains("Invalid"))
                loginResult = "unsuccessful";
            else
                loginResult = "successful";
        }

        @Then("login should be {string}")
        public void verifyLogin(String expected) {
            if (!loginResult.equals(expected))
                throw new AssertionError("Expected " + expected + " but got " + loginResult);
        }

        @When("user logs in with following credentials")
        public void loginWithTable(DataTable table) {
            List<Map<String,String>> rows = table.asMaps(String.class,String.class);
            for (Map<String,String> row : rows) {
                driver.findElement(By.id("username")).clear();
                driver.findElement(By.id("password")).clear();
                driver.findElement(By.id("username")).sendKeys(row.get("username"));
                driver.findElement(By.id("password")).sendKeys(row.get("password"));
                driver.findElement(By.id("login")).click();
            }
        }
    }

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "login.feature",
            glue = "",
            plugin = {"pretty"}
    )
    public static class Runner {}
}