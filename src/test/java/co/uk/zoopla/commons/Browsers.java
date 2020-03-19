package co.uk.zoopla.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browsers extends DriverLib {
private WebDriver initChrome()
{
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();

}
    public void launchBrowser(String browser)
    {switch (browser)
    {
        case "Chrome":
            driver = initChrome();
            break;
        //default:
        // driver = initHeadlessChrome();
    }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }
    public void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
