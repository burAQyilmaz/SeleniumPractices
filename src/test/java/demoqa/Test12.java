package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Test12 {

/*
//Open https://demoqa.com/webtables page
    //Change the name of first user
    //Verify if it is changed or not
    //Add a user to table
    //Verify if it is added or not
 */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

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

        String oldName = driver.findElement(By.className("rt-td")).getText();

        driver.findElement(By.id("edit-record-1")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Burak");
        driver.findElement(By.id("submit")).click();

        String newName = driver.findElement(By.className("rt-td")).getText();

        Assert.assertNotEquals(newName, oldName);

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Yunus");
        driver.findElement(By.id("lastName")).sendKeys("Kulcu");
        driver.findElement(By.id("userEmail")).sendKeys("yunuskulcu@gmail.com");
        driver.findElement(By.id("age")).sendKeys("39");
        driver.findElement(By.id("salary")).sendKeys("10000000");
        driver.findElement(By.id("department")).sendKeys("IT");
        driver.findElement(By.id("submit")).click();

        WebElement addedName = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]"));

        String added = addedName.getText();

        Assert.assertFalse(added.isBlank());
    }
}
