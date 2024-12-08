package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
            return new ChromeDriver();
        }
        throw new IllegalArgumentException("Browser not supported");
    }
}
