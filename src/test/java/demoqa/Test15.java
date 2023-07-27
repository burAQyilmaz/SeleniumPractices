package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Test15 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {

        driver.quit();
    }

    @Test
    public void task1() {

        //Open https://demoqa.com/frames page

        driver.get("https://demoqa.com/frames");

        //Verify if first frames header is "This is a sample page"
        driver.switchTo().frame("frame1");

        String expected = "This is a sample page";
        String actual1 = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actual1, expected);

        driver.switchTo().parentFrame();

        //Verify if second frames header is "This is a sample page"
        driver.switchTo().frame("frame2");

        String actual2 = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(actual2, expected);
    }

    @Test
    public void task2() {

        //Open https://demoqa.com/select-menu page
        driver.get("https://demoqa.com/select-menu");

        //Type "option 1" into first dropdown
        WebElement element = driver.findElement(By.id("react-select-2-input"));

        //Hit the enter
        element.sendKeys("option 1" + Keys.ENTER);

        //Verify whether the selected option is "Group 1, option 1"
        String actual1 = driver.findElement(By.className("css-1uccc91-singleValue")).getText();
        String expected1 = "Group 1, option 1";
        Assert.assertEquals(actual1, expected1);

        //Type "Ot" into second dropdown
        WebElement element2 = driver.findElement(By.id("react-select-3-input"));

        //Hit the enter
        element2.sendKeys("Ot" + Keys.ENTER);

        //Verify if the selected option is "Other"
        String actual2 = driver.findElement(By.xpath("//div[@id='selectOne']/div/div")).getText();
        String expected2 = "Other";
        Assert.assertEquals(actual2, expected2);
    }

    public void Test3(){



    }
}
