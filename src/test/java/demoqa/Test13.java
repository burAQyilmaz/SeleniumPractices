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

public class Test13 {

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

        //Open "https://demoqa.com/select-menu" page
        // Select each option of Old Style Select Menu
        // Verify if each option is selected or not
        // Tip:Use Select class and getOptions(),selectByVisibleText(),getFirstSelectedOption() methods

        driver.get("https://demoqa.com/select-menu");

        WebElement oldStyle = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(oldStyle);

        List<WebElement> options = select.getOptions();


        for (WebElement option : options) {

            select.selectByVisibleText(option.getText());
            //select.selectByIndex();

            String expected = option.getText();
            String actual = select.getFirstSelectedOption().getText();

            Assert.assertEquals(actual, expected);
            //Assert.assertTrue((option.isSelected()));
        }
    }
}
