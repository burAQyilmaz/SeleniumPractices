package practiceCydeo.day8;

import base.Base;
import org.apache.commons.compress.harmony.pack200.BandSet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigurationReader;
import utility.WebTableUtils;

import java.security.Key;

public class Tasks extends Base {

    @Test
    public void Task1() {

        //TC #1: Web table practice
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expected = "Bob Martin";
        String actual = driver.findElement(By.xpath("//table//td[contains(text(),'Bob')]")).getText();
        Assert.assertEquals(actual, expected);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        String actualDate = driver.findElement(By.xpath("//table//td[contains(text(),'Bob')]/following-sibling::td[3]")).getText();
        Assert.assertEquals(actualDate, expectedDate);
    }

    @Test
    public void Task2() {

        //TC #2: Web table practice Task1 cont.
        //1. Create a new class called WebTableUtils.
        //2. Create two methods to verify order
        driver.get("https://practice.cydeo.com/web-tables");

        //Method #1 info:
        //• Name: returnOrderDate ()
        //• Return type: String
        //• Arg1: WebDriver driver
        //• Arg2: String costumerName
        //This method should accept a costumerName and return the costumer order date
        //as a String.

        System.out.println(WebTableUtils.returnOrderDate(driver, "Samuel"));

        //Method #2 info:
        //• Name: orderVerify ()
        //• Return type: void
        //• Arg1: WebDriver driver
        //• Arg2: String costumerName
        //• Arg3: String expectedOrderDate
        //This method should accept above mentioned arguments and internally assert
        //expectedOrderDate matching actualOrderDate.

        WebTableUtils.orderVerify(driver, "Bob", "12/31/2021");
    }

    @Test
    public void Task3() {

        //TC #3: Create a custom method
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        //3- Write custom method:
        //
        //• Method name: getTableGetEmail()
        //• Return type: void
        //• Arg1: WebDriver driver
        //• Arg2: String tableNum
        //• Arg3: String firstName
        System.out.println(WebTableUtils.getTableGetEmail(driver, "2", "Tim"));

        String expectedMail="tconway@earthlink.net";
        String actualMail=WebTableUtils.getTableGetEmail(driver, "2", "Tim");
        Assert.assertEquals(actualMail,expectedMail);
    }

    @Test
    public void Task4() {
        //TC #4: Google search
        //1- Open a chrome browser
        //2- Go to: https://google.com
        String url=ConfigurationReader.getProperty("url");
        driver.get(url);

        //3- Write “apple” in search box
        String keyword=ConfigurationReader.getProperty("keyword");
        driver.findElement(By.id("APjFqb")).sendKeys(keyword+ Keys.ENTER);

        //4- Verify title:
        String actualTitle=driver.getTitle();
        String expectedTitle=keyword+" - Google'da Ara";
        Assert.assertEquals(actualTitle,expectedTitle);


        //Expected: apple - Google Search
        //
        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.
    }

}
