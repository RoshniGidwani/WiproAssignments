package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.*;

public class AllOneInTest extends BaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(AllOneInTest.class);

    @Test
    public void login_AddToCart_Checkout_Test() {

        log.info("Test started: Login → Add to Cart → Checkout");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        log.info("Performing login");
        loginPage.login("standard_user", "secret_sauce");

        log.info("Adding item to cart");
        productsPage.addItemToCart();

        log.info("Navigating to cart and checkout");
        productsPage.goToCart();
        cartPage.checkout();

        log.info("Entering checkout details");
        checkoutPage.enterDetails("Rushikesh", "Jawalekar", "445001");

        log.info("Finishing order");
        checkoutPage.finishOrder();

        log.info("Order placed successfully ✅");
    }
}