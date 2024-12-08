package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;

    @FindBy(css = "button[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartBackpack;

    @FindBy(css = "button[data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartBikeLight;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addTwoProductsToCart() {
        addToCartBackpack.click();
        addToCartBikeLight.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}
