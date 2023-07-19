package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test8 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://demoqa.com/webtables");

        List<WebElement> salaries = driver.findElements(By.xpath("//div[@class='rt-td'][5]"));

        int sum = 0;

        for (WebElement salary : salaries) {
            sum+=salary.getText().isBlank() ? 0: Integer.parseInt(salary.getText());
        }

        System.out.println("sum = " + sum);
        Assert.assertEquals(sum,24000);
    }
}
