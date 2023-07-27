package jQueryUI;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 extends Base {

    @Test
    public void Test1() {

        //Open https://jqueryui.com/selectable/ page
        driver.get("https://jqueryui.com/selectable/");
        driver.switchTo().frame(0);

        //Select Item 4
        WebElement item4 = driver.findElement(By.xpath("//li[.='Item 4']"));
        item4.click();

        //Verify if Item 4 is selected
        String selectedItem4 = item4.getAttribute("class");
        Assert.assertTrue(selectedItem4.contains("selected"));

        //Select Item 7
        WebElement item7 = driver.findElement(By.xpath("//li[.='Item 7']"));
        item7.click();

        //Verify if Item 4 is not selected
        selectedItem4 = item4.getAttribute("class");
        Assert.assertFalse(selectedItem4.contains("selected"));

        //Verify if Item 7 is selected
        String selectedItem7 = item7.getAttribute("class");
        Assert.assertTrue(selectedItem7.contains("selected"));
    }
}
