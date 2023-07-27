package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.ConfigurationReader;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class Base {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        String browser= ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {

        driver.quit();
    }
}
