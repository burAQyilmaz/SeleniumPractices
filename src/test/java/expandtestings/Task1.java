package expandtestings;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Driver;

public class Task1 {

    @Test
    public void Test1() {

        //Open https://practice.expandtesting.com/inputs page
        Driver.getDriver().get("https://practice.expandtesting.com/inputs");

        //Input a number into "Input: Number" box
        Faker faker = new Faker();
        String inputNumber = faker.numerify("####");
        Driver.getDriver().findElement(By.id("input-number")).sendKeys(inputNumber);


        //Input a text into "Input: Text" box
        String inputText = faker.letterify("?????");
        Driver.getDriver().findElement(By.id("input-text")).sendKeys(inputText);

        //Input a password into "Input: Password" box
        String inputPassword = faker.internet().password();
        Driver.getDriver().findElement(By.id("input-password")).sendKeys(inputPassword);

        //Input a date
        String inputDate = "12/12/2012";
        Driver.getDriver().findElement(By.id("input-date")).sendKeys(inputDate);

        //Click Display inputs button
        Driver.getDriver().findElement(By.id("btn-display-inputs")).click();

        //Verify if results and inputs are same
        String outputNumber = Driver.getDriver().findElement(By.id("output-number")).getText();
        String outputText = Driver.getDriver().findElement(By.id("output-text")).getText();
        String outputPassword = Driver.getDriver().findElement(By.id("output-password")).getText();

        WebElement date = Driver.getDriver().findElement(By.id("output-date"));
        String outputDate = date.getText().substring(8) + "/" + date.getText().substring(5, 7) + "/" + date.getText().substring(0, 4);

        Assert.assertEquals(inputNumber, outputNumber);
        Assert.assertEquals(inputText, outputText);
        Assert.assertEquals(inputPassword, outputPassword);
        Assert.assertEquals(inputDate, outputDate);
    }
}
