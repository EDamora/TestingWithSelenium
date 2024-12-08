package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    @FindBy(id = "continue")
    public WebElement continueButton;  // pastikan locator benar

    @FindBy(className = "error-message-container")
    public WebElement errorMessage;

    @FindBy(className = "complete-header")
    public WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();  // Pastikan tombol dapat diklik
    }
}
