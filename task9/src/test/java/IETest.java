import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IETest {
    WebDriverFactory WebDriverFactory = new WebDriverFactory();
    By searchField = By.xpath("//*[@name='q']");
    By sites = By.xpath("//*[@class='LC20lb MBeuO DKV0Md']");
    private String LinkText="SofServe";
    private String currenturl;

    @Test
    public  void testEI(){
        WebDriver driver = WebDriverFactory.createWebDriver(DriverType.FIREFOX);
        WebDriverWait wait = new WebDriverWait(driver, 4);
        driver.get("https://google.com");
        WebElement searchELement = driver.findElement(searchField);
        searchELement.clear();
        searchELement.sendKeys("SoftServe");
        searchELement.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sites));
        WebElement SoftServe = driver.findElement(sites);
        SoftServe.click();
        currenturl= driver.getCurrentUrl();
        Assert.assertTrue(currenturl.contains("softserve"),"Not contain");

        driver.quit();
    }

}
