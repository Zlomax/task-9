import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        driver.manage().window().maximize();
        return driver;
    }
    protected WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    protected WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
