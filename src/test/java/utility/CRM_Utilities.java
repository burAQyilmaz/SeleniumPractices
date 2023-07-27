package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Utilities {

    public static void login_crm(WebDriver driver){

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk1@cydeo.com");

        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");

        driver.findElement(By.className("login-btn")).click();
    }
    public static void login_crm(WebDriver driver, String username, String password){

        driver.findElement(By.name("USER_LOGIN")).sendKeys(username);

        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

        driver.findElement(By.className("login-btn")).click();
    }


}
