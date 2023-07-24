package practiceCydeo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tasks {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {

        driver.quit();
    }

    @Test
    public void Task1() {

        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");


        //3. Click to “Add Element” button
        driver.findElement(By.xpath("//button[.='Add Element']")).click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement delete = driver.findElement(By.xpath("//button[.='Delete']"));
        Assert.assertTrue(delete.isDisplayed());

        //5. Click to “Delete” button.
        delete.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            Assert.assertFalse(delete.isDisplayed());
            System.out.println("Element is not deleted.");
        } catch (RuntimeException e) {
            System.out.println("Element is deleted successfully.");
        }
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }

    @Test
    public void Task2() {

//TC #2: Radiobutton handling
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//3. Click to “Hockey” radio button
        WebElement hockey = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockey.click();
//4. Verify “Hockey” radio button is selected after clicking.
        Assert.assertTrue(hockey.isSelected());

//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }

    @Test
    public void Task3() {
        //TC #3: Utility method task for (continuation of Task2)
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons
        //3. Click to “Hockey” radio button
        //4. Verify “Hockey” radio button is selected after clicking.
        //
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        //
        //Create a utility method to handle above logic.
        //Method name: clickAndVerifyRadioButton
        //Return type: void or boolean
        //Method args:
        //1. WebDriver
        //2. Name attribute as String (for providing which group of radio buttons)
        //3. Id attribute as String (for providing which radio button to be clicked)
        //Method should loop through the given group of radio buttons. When it finds the
        //matching option, it should click and verify option is Selected.
        //Print out verification: true

        clickAndVerifyRadioButton(driver, "sport", "hockey");

    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String attributeName, String attributeID) {

        driver.get("https://practice.cydeo.com/radio_buttons");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='" + attributeName + "']"));

        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("id").equals(attributeID)) {
                radioButton.click();
                Assert.assertTrue(radioButton.isSelected());
                System.out.println("true");
            }
        }
    }

    @Test
    public void Task4() {
//TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select simpleDropdownSelect = new Select(simpleDropdown);

        String actualSelectedValue = simpleDropdownSelect.getFirstSelectedOption().getText();
        String expectedSimple = "Please select an option";

        Assert.assertEquals(actualSelectedValue, expectedSimple);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        WebElement stateSelection = driver.findElement(By.id("state"));
        Select stateSelectionSelect = new Select(stateSelection);

        String actualStateSelection = stateSelectionSelect.getFirstSelectedOption().getText();
        String expectedState = "Select a State";

        Assert.assertEquals(actualStateSelection, expectedState);
    }

    @Test
    public void Task5() {
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select Illinois
        WebElement stateSelection = driver.findElement(By.id("state"));
        Select stateSelectionSelect = new Select(stateSelection);

        stateSelectionSelect.selectByVisibleText("Illinois");
        stateSelectionSelect.selectByValue("IL");
        stateSelectionSelect.selectByIndex(14);

        //4. Select Virginia
        stateSelectionSelect.selectByVisibleText("Virginia");
        stateSelectionSelect.selectByValue("VA");
        stateSelectionSelect.selectByIndex(47);


        //5. Select California
        stateSelectionSelect.selectByVisibleText("California");
        stateSelectionSelect.selectByValue("CA");
        stateSelectionSelect.selectByIndex(5);

        //6. Verify final selected option is California.
        String actualCalifornia = stateSelectionSelect.getFirstSelectedOption().getText();
        String expectedCalifornia = "California";

        //Use all Select options. (visible text, value, index)

    }

    @Test
    public void Task6() {
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1933” and verify it is selected.
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        //Select year using : visible text
        selectYear.selectByVisibleText("1933");

        //Select month using : value attribute
        selectMonth.selectByValue("11");

        //Select day using : index number
        selectDay.selectByIndex(0);

        String expectedYear = "1933";
        String actualYear = selectYear.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear, expectedYear);

        String expectedMonth = "December";
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, expectedMonth);

        String expectedDay = "1";
        String actualDay = selectDay.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay, expectedDay);
    }

    @Test
    public void Task7() {

        //TC #7: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Click to non-select dropdown
        driver.findElement(By.cssSelector(".btn.btn-secondary.dropdown-toggle")).click();

        //4. Select Facebook from dropdown
        driver.findElement(By.linkText("Facebook")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String expected = "Facebook - Giriş Yap veya Kaydol";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Task8() throws InterruptedException {
        //TC #8: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> options = languages.getOptions();

        for (WebElement option : options) {
            option.click();
            Thread.sleep(1000);
        }

        //4. Print out all selected values.
        System.out.println("All selected values:");
        System.out.println("--------------------");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //5. Deselect all values.
        languages.deselectAll();
    }
}
