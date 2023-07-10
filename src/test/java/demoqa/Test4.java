package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Burak Yilmaz");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(("burakyilmaz@gmail.com"));

        WebElement address = driver.findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        address.sendKeys("Bergama/Turkey");

        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Eskisehir/Turkey");

        JavascriptExecutor jse = (JavascriptExecutor)driver; //scrolldown
        jse.executeScript("window.scrollBy(0,250)");

        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();

        String result=driver.findElement(By.xpath("//div[@id='output']/div")).getText();
        System.out.println(result);

        driver.close();
    }
}
