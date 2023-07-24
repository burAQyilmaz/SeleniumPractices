package practiceCydeo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

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
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice
     */

        driver.get("https://practice.cydeo.com");

        String expectedUrl = "cydeo";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    public void Task2() {

/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:

Expected: No A/B Test

5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */

        driver.get("https://practice.cydeo.com");

        driver.findElement(By.linkText("A/B Testing")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "No A/B Test";

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.navigate().back();
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Practice";

        Assert.assertEquals(actualTitle2, expectedTitle2);
    }

    public void Task3() {

        /*
        TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:

Expected: Title should start with “apple” word
         */

        driver.get("https://google.com");

        driver.findElement(By.id("APjFqb")).sendKeys("apple");
        driver.findElement(By.xpath("//input[@class='gNO89b'][1]")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle));

    }

    @Test
    public void task4() throws InterruptedException {

        /*
       TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
         */

        driver.get("http://library2.cybertekschool.com/login.html");

        driver.findElement(By.className("form-control")).sendKeys("incorrect@email.com");

        driver.findElement(By.id("inputPassword")).sendKeys("incorrect password");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String expected = "Sorry, Wrong Email or Password";
        String actual = driver.findElement(By.className("alert-danger")).getText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Task5() {

/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:

Expected: first name
 */

        driver.get("https://practice.cydeo.com/registration_form");

        String actual = driver.findElement(By.tagName("h2")).getText();
        String expected = "Registration form";

        Assert.assertEquals(actual, expected);

        String actual1 = driver.findElement(By.className("form-control")).getAttribute("placeholder");
        String expected2 = "first name";

        Assert.assertEquals(actual1, expected2);

    }

    @Test
    public void homeWork1() {

        /*
        TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”
         */

        driver.get("https://www.etsy.com");

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);

        String expected = "Wooden spoon - Etsy";
        String actual = driver.getTitle();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void homeWork2() {

        /*
        TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
         */

        driver.get("http://zero.webappsecurity.com/login.html");

        String expected = "Log in to ZeroBank";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void homeWork3() {

/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail

5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */
        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();

        String expected="Gmail";
        String actual=driver.getTitle();
        Assert.assertTrue(actual.contains(expected));

        driver.navigate().back();
        String expected2="Google";
        String actual2=driver.getTitle();
        Assert.assertTrue(actual2.contains(expected2));

    }

    @Test
    public void homeWork4(){

        /*
        TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator
         */

        driver.get("https://practice.cydeo.com/inputs");
        driver.findElement(By.className("nav-link")).click();

        String expected="Practice";
        String actual=driver.getTitle();
        Assert.assertEquals(actual,expected);
    }

}
