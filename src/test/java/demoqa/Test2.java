package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();

        WebElement firstName=driver.findElement(By.id("firstName"));

        firstName.sendKeys("Burak");

        WebElement lastName= driver.findElement(By.id("lastName"));

        lastName.sendKeys("Yilmaz");

        WebElement email= driver.findElement(By.id("userEmail"));

        email.sendKeys("burakyilmaz@gmail.com");

        WebElement gender1=driver.findElement(By.xpath("//label[@for='gender-radio-1']"));

        gender1.click();

        Thread.sleep(2000);

        WebElement gender2=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));

        gender2.click();

        Thread.sleep(2000);

        WebElement gender3=driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        gender3.click();

        Thread.sleep(2000);

        WebElement mobileNumber=driver.findElement(By.id("userNumber"));

        mobileNumber.sendKeys("5424644632");





    }
}
