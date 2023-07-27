package demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Test14 {


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

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();

        String expectedText = "You clicked a button";
        String actualText = alert.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void task2() throws InterruptedException {

        //Open  https://demoqa.com/alerts page
        //Click second "Click me" button
        //Wait 5 seconds
        //Verify if displayed text is "This alert appeared after 5 seconds"

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();

        String actualText2 = alert.getText();
        String expectedText2 = "This alert appeared after 5 seconds";
        Assert.assertEquals(actualText2, expectedText2);
    }

    @Test
    public void task3() throws InterruptedException {

        //Open  https://demoqa.com/alerts page
        //Click third "Click me" button
        //Click ok button.
        //Verify if "You selected Ok" text occurs

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("confirmButton")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String expectedAlertText = "You selected Ok";
        String actualAlertText = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void task4() throws InterruptedException {

        //Open  https://demoqa.com/alerts page
        //Click fourth "Click me" button
        //Input your name
        //Accept alert
        //Verify if result text is "You entered "+$yourName text occurs

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Burak");
        alert.accept();

        String expected = "You entered Burak";
        String actual = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals(actual, expected);
    }
}
