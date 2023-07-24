package practiceCydeo.day6;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class Task4 extends Base {

    @Test
    public void Task4() {
        //TC #4: Iframe practice
        //
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups
        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        //4. Assert: “Your content goes here.” Text is displayed.
        WebElement iframeId=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeId);
        //driver.switchTo().frame(0);

        String expected="Your content goes here.";
        String actual=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual,expected);

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        String actualHead=driver.findElement(By.tagName("h3")).getText();
        String expectedHead="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHead,expectedHead);
    }





}
