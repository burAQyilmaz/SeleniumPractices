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

public class Test11 {

    //Open https://demoqa.com/webtables page
    //Find the average of the ages (from table)
    //Verify if the integer part of the average of the ages is 37

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {

        //driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://demoqa.com/webtables");

        List<WebElement> ages = driver.findElements(By.xpath("//div[@class='rt-td'][3]"));

        int sum = 0;
        int counter=0;

        for (WebElement eachAge : ages) {

            if (!eachAge.getText().isBlank()) {

                sum += Integer.parseInt(eachAge.getText());
                counter++;
            }
        }
        int average=sum/counter;

        System.out.println("average = " + average);

        Assert.assertEquals(average,37);
    }
}
