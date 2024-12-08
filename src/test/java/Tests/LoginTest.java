package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Utils.WebDriverFactory;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testInvalidUsername() {
        loginPage.login("wrong_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void testInvalidPassword() {
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void testEmptyFields() {
        loginPage.login("", "");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(7000); // Delay kira2 7 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
