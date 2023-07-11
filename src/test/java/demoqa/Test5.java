package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demoqa.com/accordian");
        driver.manage().window().maximize();

        WebElement cardHeader1= driver.findElement(By.id("section1Heading"));
        cardHeader1.click();

        WebElement cardHeader3= driver.findElement(By.id("section3Heading"));
        cardHeader3.click();

        WebElement section3Content= driver.findElement(By.id("section3Content"));

        System.out.println("cardHeader.getText() = " + cardHeader3.getText());
        System.out.println("-----------------------------------");
        System.out.println("section3Content.getText() = " + section3Content.getText());

        driver.close();
    }
}
