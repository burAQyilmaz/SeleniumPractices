package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        if (yesRadio.getAttribute("class").contains("disabled")) System.err.println("Yes radio button is not enable");
        else yesRadio.click();

        WebElement impressiveRadio = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        if (impressiveRadio.getAttribute("class").contains("disabled")) System.err.println("Impressive radio button is not enable");
        else impressiveRadio.click();

        WebElement noRadio = driver.findElement(By.xpath("//label[@for='noRadio']"));
        if (noRadio.getAttribute("class").contains("disabled")) System.err.println("No radio button is not enable");
        else noRadio.click();

        driver.close();

    }
}
