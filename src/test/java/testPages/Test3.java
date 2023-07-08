package testPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");

        WebElement element= driver.findElement(By.className("explanation"));

        System.out.println(element.getText().toLowerCase().contains("elements"));

        driver.close();
    }
}
