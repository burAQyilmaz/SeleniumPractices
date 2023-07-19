package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Test9 {

    //Open https://demoqa.com/checkbox page
    //Click Home/Download/Excel File.doc
    //Verify if displayed text contains "excelFile" or not

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod() {

    driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("(//button[@title='Toggle'])[1]")).click();
        driver.findElement(By.xpath("(//button[@title='Toggle'])[4]")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-excelFile']")).click();

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("excelFile"));

    }

}

