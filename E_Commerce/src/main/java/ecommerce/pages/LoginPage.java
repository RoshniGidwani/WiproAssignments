package ecommerce.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static By username = By.name("user-name");
    public static By password = By.name("password");
    public static By loginBtn = By.id("login-button");
    public static By errorMsg = By.cssSelector("h3[data-test='error']");
    public static By inventory = By.className("inventory_list");
}