package practiceCydeo.day7;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserUtils;
import utility.CRM_Utilities;

import java.util.ArrayList;
import java.util.List;

public class Tasks extends Base {


    @Test
    public void Task1() {
        //TC #1: Window Handle practice
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains("etsy.com")) break;
        }

        //5. Assert: Title contains “Etsy”
        String expectedInTitle = "Etsy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        //Lines to be pasted:
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
    }

    @Test
    public void Task2() {

        //TC #2: Create utility method
        //1. Create a new class called BrowserUtils
        //2. Create a method to make Task1 logic re-usable
        //3. When method is called, it should switch window and verify title.
        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        BrowserUtils.switchWindowAndVerify(driver, "facebook.com", "Facebook");

        //Method info:
        //• Name: switchWindowAndVerify
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedInUrl
        //• Arg3: String expectedTitle
    }

    @Test
    public void linkTest() {

        //Open https://practice.cydeo.com/ page
        driver.get("https://practice.cydeo.com/");

        //Open each link in new tab
        List<WebElement> links = driver.findElements(By.tagName("a"));


        for (WebElement link : links) {
            link.sendKeys(Keys.CONTROL, Keys.RETURN);

        }

        //Verify if each page url contains "cydeo.com"
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (String tab : tabs) {
            String expectedUrl = "cydeo.com";
            String actualUrl = driver.switchTo().window(tab).getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedUrl));
        }
    }

    @Test
    public void Task3() {

        //TC #3: Login scenario
        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");

        //5. Click to `Log In` button
        driver.findElement(By.className("login-btn")).click();

        //6. Verify title is as expected:
        String expected = "Portal";
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected));

        //Expected: Portal

        //USERNAME PASSWORD
        //helpdesk1@cybertekschool.com UserUser
        //Helpdesk2@cybertekschool.com UserUser
    }

    @Test
    public void Task4() {
        //TC #4: Create utility method
        //1. Create a new method for login
        //2. Create a method to make Task3 logic re-usable
        //3. When method is called, it should simply login

        driver.get("http://login1.nextbasecrm.com/");
        //CRM_Utilities.login_crm(driver);
        CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");

        //This method should have at least 2 overloaded versions.
        //Method #1 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
        //
        //Method #2 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String username
        //• Arg3: String password
    }

    @Test
    public void Task5() {
        //TC #5: Create utility method
        //1. Create a new method for title verification
        //2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual title
        //
        //Method info:
        //• Name: verifyTitle()
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedTitle

        driver.get("https://google.com");
        BrowserUtils.verifyTitle(driver,"Google");
    }
}
