package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.*;
import Utils.WebDriverFactory;

import java.time.Duration;

public class CheckoutTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // Explicit wait
        driver.get("https://www.saucedemo.com/");

        // Login dan navigasi ke checkout page
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.addTwoProductsToCart();
        productsPage.goToCart();

        cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void testSuccessfulCheckout() {
        // Isi data checkout yang valid
        checkoutPage.fillCheckoutInfo("Erick", "Damora", "99999");

        // Klik tombol Continue
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.continueButton));
        continueButton.click();

        // Tunggu beberapa detik agar proses dapat dilihat
        try {
            Thread.sleep(2000); // Delay selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tunggu tombol Finish muncul
        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));

        try {
            Thread.sleep(2000); // Delay selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klik tombol Finish untuk menyelesaikan checkout
        finishButton.click();

        // Tunggu beberapa detik agar proses dapat dilihat
        try {
            Thread.sleep(2000); // Delay selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tunggu pesan konfirmasi checkout
         WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".complete-header")));

        // Verifikasi pesan konfirmasi
         Assert.assertTrue(confirmationMessage.getText().equalsIgnoreCase("Thank you for your order!"), "Checkout confirmation not displayed correctly!");
    }

    @Test(priority = 2)
 public void testMissingFirstName() {
        // Negative Case: First Name kosong
        checkoutPage.fillCheckoutInfo("", "Damora", "99999");
        checkoutPage.clickContinue();

        // Menunggu error message muncul
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-message-container")));
      Assert.assertTrue(errorMessage.getText().contains("Error: First Name is required"), "Error message not displayed for missing first name!");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000); // Delay kira-kira 7 detik untuk debugging
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
