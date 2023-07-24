package practiceCydeo.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tasks {

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
    public void Task1() {

        /*
        TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
         */

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        WebElement forgot = driver.findElement(By.cssSelector(".example>h2"));
        WebElement emailText = driver.findElement(By.cssSelector(".large-6.small-12.columns>label"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement retrieve = driver.findElement(By.cssSelector("#form_submit"));
        WebElement powered = driver.findElement(By.cssSelector(".large-4.large-centered.columns>div"));

        Assert.assertTrue(home.isDisplayed());
        Assert.assertTrue(forgot.isDisplayed());
        Assert.assertTrue(emailText.isDisplayed());
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(retrieve.isDisplayed());
        Assert.assertTrue(powered.isDisplayed());
    }

    @Test
    public void Task2() {

        /*
        TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
         */

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement forgot = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement retrieve = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        WebElement powered = driver.findElement(By.xpath("//div[contains(text(),'Powered')]"));

        Assert.assertTrue(home.isDisplayed());
        Assert.assertTrue(forgot.isDisplayed());
        Assert.assertTrue(emailText.isDisplayed());
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(retrieve.isDisplayed());
        Assert.assertTrue(powered.isDisplayed());
    }

    @Test
    public void Task3() {

/*
TC #6: XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */
        driver.get("http://practice.cydeo.com/multiple_buttons");

        driver.findElement(By.xpath("//button[.='Button 1']")).click();
        String actualB1 = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected = "Clicked on button one!";
    }

    @Test
    public void Task4() {

/*
TC #4: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links
 */

        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("links.size() = " + links.size());

        for (WebElement link : links) {
            System.out.println("link.getText() = " + link.getText());
            System.out.println("link.getAttribute(\"href\") = " + link.getAttribute("href"));
        }
    }

    @Test
    public void Task5() {

        /*
        Practice: Checkboxes
1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
         */

        driver.get("http://practice.cydeo.com/checkboxes");

        WebElement box1 = driver.findElement(By.id("box1"));
        Assert.assertFalse(box1.isSelected());

        WebElement box2 = driver.findElement(By.id("box2"));
        Assert.assertTrue(box2.isSelected());

        box1.click();
        box2.click();

        Assert.assertTrue(box1.isSelected());
        Assert.assertFalse(box2.isSelected());
    }

    @Test
    public void Task6() {

        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeo = driver.findElement(By.linkText("CYDEO"));
        Assert.assertTrue(cydeo.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();

        //5- Verify it is displayed, again.
        cydeo = driver.findElement(By.linkText("CYDEO"));//to handle this issue we should locate again
        Assert.assertTrue(cydeo.isDisplayed());

        //This is a simple StaleElementReferenceException to understand what is
        //this exception and how to handle it.
    }
}
