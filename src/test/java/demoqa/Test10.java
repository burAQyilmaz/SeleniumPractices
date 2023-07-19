package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test10 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void selectedtest1() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        WebElement oldStyle = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(oldStyle);

        select.selectByIndex(2);

        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            Thread.sleep(1000);
            select.selectByVisibleText(option.getText());

            String expected = option.getText();
            String actual = select.getFirstSelectedOption().getText();
            Assert.assertEquals(actual, expected);
        }
    }

    @Test
    public void selectedtest2() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        WebElement cars = driver.findElement(By.id("cars"));

        Select select = new Select(cars);

        select.selectByVisibleText("Saab");
        String actual = select.getFirstSelectedOption().getText();
        String expected = "Saab";

        Assert.assertEquals(expected, actual);
    }

}
