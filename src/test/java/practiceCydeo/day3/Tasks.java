package practiceCydeo.day3;

import org.openqa.selenium.By;
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
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

PS: Inspect and decide which locator you should be using to locate web
elements.
         */

        driver.get("https://login1.nextbasecrm.com/");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect");
        driver.findElement(By.className("login-btn")).click();

        String expected = "Incorrect login or password";
        String actual = driver.findElement(By.className("errortext")).getText();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Task2() {

        /*
        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:

Expected: Forgot your password?

5- Verify “forgot password” href attribute’s value contains expected:

Expected: forgot_password=yes

PS: Inspect and decide which locator you should be using to locate web
elements.
         */
        driver.get("https://login1.nextbasecrm.com/");

        String actual = driver.findElement(By.className("login-item-checkbox-label")).getText();
        String expected = "Remember me on this computer";
        Assert.assertEquals(actual, expected);

        String actual2 = driver.findElement(By.className("login-link-forgot-pass")).getText();
        String expected2 = "FORGOT YOUR PASSWORD?";
        Assert.assertEquals(actual2, expected2);

        String actual3 = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        String expected3 = "forgot_password=yes";
        Assert.assertTrue(actual3.contains(expected3));

    }

    @Test
    public void Task3() {
        /*
        TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:

Expected: Log In

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

        driver.get("https://login1.nextbasecrm.com/");
        String expected = "Log In";
        String actual = driver.findElement(By.className("login-btn")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Task4() {

        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:

Expected: Reset password

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        String expected="Reset password";
        String actual=driver.findElement(By.className("login-btn")).getAttribute("value");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void Task5(){
        /*
        TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected

Expected: Login or E-mail not found

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrectUsername");
        driver.findElement(By.className("login-btn")).click();
        String actual= driver.findElement(By.className("errortext")).getText();
        String expected="Login or E-mail not found";
        Assert.assertEquals(actual,expected);
    }
}
