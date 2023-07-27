package practiceCydeo.day10;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BrowserUtils;
import utility.Driver;

import java.util.Locale;

public class Tasks {

    Faker faker = new Faker(new Locale("en-us"));

    @Test
    public void Task1() {

//TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get("https://practice.cydeo.com/registration_form");

        //3. Enter first name
        Driver.getDriver().findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        Actions actions = new Actions(Driver.getDriver());

        //4. Enter last name
        actions.sendKeys(Keys.TAB + faker.name().lastName());

        //5. Enter username
        actions.sendKeys(Keys.TAB + faker.name().username().replace(".", ""));

        //6. Enter email address
        actions.sendKeys(Keys.TAB + faker.internet().emailAddress());

        //7. Enter password
        actions.sendKeys(Keys.TAB + faker.internet().password());

        //8. Enter phone number
        actions.sendKeys(Keys.TAB + faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        actions.sendKeys(Keys.TAB, Keys.SPACE);

        //10.Enter date of birth
        actions.sendKeys(Keys.TAB + "12/12/2012");

        //11.Select Department/Office
        actions.sendKeys(Keys.TAB, Keys.ARROW_DOWN);

        //12.Select Job Title
        actions.sendKeys(Keys.TAB, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);

        //13.Select programming language from checkboxes
        actions.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);

        //14.Click to sign up button
        actions.sendKeys(Keys.ENTER).perform();

        //15.Verify success message “You've successfully completed registration!” is
        //displayed.
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = Driver.getDriver().findElement(By.tagName("p")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense
    }

    @Test
    public void Task2() {

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        Driver.getDriver().findElement(By.id("file-upload")).sendKeys("C:\\Users\\Pc\\Desktop\\vesikalık.png");

        //3. Upload the file.
        Driver.getDriver().findElement(By.id("file-submit")).click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        String expectedResult = "File Uploaded!";
        String actualMessage = Driver.getDriver().findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualMessage, expectedResult);
    }

    @Test
    public void Task3() throws InterruptedException {

        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement text1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]"));
        WebElement text2 = Driver.getDriver().findElement(By.xpath("(//h5)[2]"));
        WebElement text3 = Driver.getDriver().findElement(By.xpath("(//h5)[3]"));

        WebElement view1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]/following-sibling::a"));
        WebElement view2 = Driver.getDriver().findElement(By.xpath("(//h5)[2]/following-sibling::a"));
        WebElement view3 = Driver.getDriver().findElement(By.xpath("(//h5)[3]/following-sibling::a"));

        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();
        BrowserUtils.sleep(3);

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(text1.isDisplayed());
        //b. “view profile” is displayed
        Assert.assertTrue(view1.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(img2).perform();
        BrowserUtils.sleep(3);


        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(text2.isDisplayed());
        //b. “view profile” is displayed
        Assert.assertTrue(view2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(img3).perform();
        BrowserUtils.sleep(3);

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(text3.isDisplayed());
        //b. “view profile” is displayed
        Assert.assertTrue(view3.isDisplayed());
    }

    @Test
    public void Test4_5() {

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//div[.='Powered by CYDEO']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(poweredByCydeo).perform();

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button

        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        actions.moveToElement(home).perform();
    }

    @Test
    public void Task6() {

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i <10 ; i++) {

            js.executeScript("window.scrollBy(0,750)");
            BrowserUtils.sleep(3);
        }
        for (int i = 0; i <10 ; i++) {

            js.executeScript("window.scrollBy(0,-750)");
            BrowserUtils.sleep(3);
        }
    }

    @Test
    public void Task7() {

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //3- Scroll down to “Cydeo” link
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        WebElement cydeo=Driver.getDriver().findElement(By.linkText("CYDEO"));
        js.executeScript("arguments[0].scrollIntoView(true)",cydeo);

        //4- Scroll up to “Home” link

        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        js.executeScript("arguments[0].scrollIntoView(true)",home);

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method
    }
}
