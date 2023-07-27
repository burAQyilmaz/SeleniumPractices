package jQueryUI;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.Test1;

public class Task1 extends Base {

    @Test
    public void Test1() {
        //Open https://jqueryui.com/selectable/ page
        driver.get("https://jqueryui.com/selectable/");

        //Click "Display as grid" link (Right side of page, under Examples)
        driver.findElement(By.linkText("Display as grid")).click();

        //Select number 10
        driver.switchTo().frame(0);
        WebElement element10 = driver.findElement(By.xpath("//ol[@id='selectable']/li[10]"));
        element10.click();

        //Verify if number 10 is selected
        Assert.assertTrue(element10.getAttribute("class").contains("selected"));
    }
}
