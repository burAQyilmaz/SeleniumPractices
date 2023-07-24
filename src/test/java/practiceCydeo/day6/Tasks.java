package practiceCydeo.day6;

import base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Tasks extends Base {

    @Test
    public void Task1() {
        //TC #1: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

        //3. Click to “Click for JS Alert” button
        driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expected1="You successfully clicked an alert";
        String actual1= driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual1,expected1);

    }
    @Test
    public void Task2() {
        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

        //3. Click to “Click for JS Confirm” button
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        String expected2="You clicked: Ok";
        String actual2= driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual2,expected2);

    }
    @Test
    public void Task3() {
        //TC #3: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

        //3. Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();

        //4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        String expected3="You entered: hello";
        String actual3= driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual3,expected3);

    }

}
