package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();


        WebElement stroke1= driver.findElement(By.xpath("//button[@title='Toggle']"));

        stroke1.click();

        Thread.sleep(2000);


        WebElement stroke3= driver.findElement(By.xpath("(//button[@title='Toggle'])[3]"));

        stroke3.click();

        Thread.sleep(2000);


        WebElement stroke4= driver.findElement(By.xpath("(//button[@title='Toggle'])[4]"));

        stroke4.click();

        Thread.sleep(2000);


        WebElement veu= driver.findElement(By.xpath("//label[@for='tree-node-veu']"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        veu.click();

        Thread.sleep(2000);


        String result=driver.findElement(By.xpath("//span[@class='text-success']")).getText();

        if(result.equals("veu")) System.out.println("Test passed");
        else System.out.println("test failed");

        driver.close();
    }
}
