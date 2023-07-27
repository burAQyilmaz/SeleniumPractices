package utility;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class BrowserUtils {

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle) {

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(expectedInUrl)) break;
        }

        String expectedInTitle = expectedTitle;
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle) {

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
