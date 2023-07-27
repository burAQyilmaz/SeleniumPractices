package jQueryUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Driver;

public class Task3 {

    @Test
    public void Task3(){
        //Open https://jqueryui.com/selectable/ page
        Driver.getDriver().get("https://jqueryui.com/selectable/");

        //Click "Display as grid" link (Right side of page, under Examples)
        Driver.getDriver().findElement(By.xpath("//a[.='Display as grid']")).click();

        //Select number 10
        Driver.getDriver().switchTo().frame(0);
        WebElement ten=Driver.getDriver().findElement(By.xpath("//ol[@id='selectable']/li[10]"));
        ten.click();

        //Verify if number 10 is selected
        String attributeTen=ten.getAttribute("class");
        Assert.assertTrue(attributeTen.contains("selected"));
    }
}
