package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();

        if(driver.getTitle().equals("DEMOQA"))
            System.out.println("Tested passed");
        else System.out.println("Test failed");

        driver.close();
    }
}
