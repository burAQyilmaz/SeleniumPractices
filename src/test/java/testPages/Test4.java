package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserUtils;
import utility.Driver;

import java.util.List;

public class Test4 {

    @Test
    public void Test213() {
        //Open https://www.cambridgeenglish.org/learning-english/activities-for-learners/ page
        Driver.getDriver().get("https://www.cambridgeenglish.org/learning-english/activities-for-learners/");

        //Click all check boxes under Learning English header

        List<WebElement> options = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement option : options) {
            option.click();
        }

        //Check if all check boxes are selected
        for (WebElement option : options) {
            Assert.assertTrue(option.isSelected());
        }

        //Click "Clear all" button
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.className("cele-filters__reset")).click();

        //Check if all check boxes are not selected
        options = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement option : options) {
            Assert.assertFalse(option.isSelected());
        }
    }
}
