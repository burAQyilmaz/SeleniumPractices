package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String costumerName) {

        return driver.findElement(By.xpath("//table//td[contains(text(),'" + costumerName + "')]/following-sibling::td[3]")).getText();
    }

    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate) {

        String actualOrderDate = returnOrderDate(driver, costumerName);
        Assert.assertEquals(actualOrderDate, expectedOrderDate);
    }

    public static String getTableGetEmail(WebDriver driver, String tableNum, String firstName) {

        return driver.findElement(By.xpath("//table[" + tableNum + "]//td[text()='" + firstName + "']/following-sibling::td[1]")).getText();
    }


}

