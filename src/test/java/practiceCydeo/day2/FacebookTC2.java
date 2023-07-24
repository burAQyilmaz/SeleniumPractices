package practiceCydeo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class FacebookTC2 {

    /*/*
    TC #1: Facebook title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify title:
Expected: “Facebook - Log In or Sign Up”
TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook”
     */

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
    public void titleVerification(){

        /*TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook”*/

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("burak@gmfl.com");
        driver.findElement(By.id("pass")).sendKeys("bsdbgb");
        driver.findElement(By.name("login")).click();

        String expected="Facebook - Giriş Yap veya Kaydol";
        String actual=driver.getTitle();

        Assert.assertEquals(actual,expected);
    }
}
