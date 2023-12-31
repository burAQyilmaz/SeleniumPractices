package practiceCydeo.extraTasks;

import org.testng.annotations.Test;

public class Tasks {

    @Test
    public void Task1_2(){

//TC #1: Smartbear software link verification
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click to Login button
//6. Print out count of all the links on landing page
//7. Print out each link text on this page
//Mini-Task: CREATE A CLASS à SmartBearUtils
//• Create a method called loginToSmartBear
//• This method simply logs in to SmartBear when you call it.
//• Accepts WebDriver type as parameter
//TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click on Login button
//6. Click on Order
//7. Select familyAlbum from product, set quantity to 2
//8. Click to “Calculate” button
//9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
//10.Click on “visa” radio button
//11.Generate card number using JavaFaker
//12.Click on “Process”
//13.Verify success message “New order has been successfully added.”

    }

    @Test
    public void Task3(){

        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        //2. Click on View all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”

    }

    @Test
    public void Task4(){

        //page
        //TC #3: Counting the number of links that does not have text
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of links that does not have text and verify
        //Expected: 109
        //
        //NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
        //FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
        //IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
        //VERIFICATION.


    }

    @Test
    public void Task5(){

        //Task #: Gas Mileage Calculator Automation Test
        //
        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net
        //3. Search for “gas mileage” using search box
        //4. Click on the “Gas Mileage Calculator” link
        //
        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        //b. “Gas Mileage Calculator” label is displayed
        //6. Locate, clear and type “7925” into “Current odometer” field
        //7. Locate, clear and type “7550” into “Previous odometer” field
        //8. Locate, clear and type “16” into “Gas added” field
        //9. Locate, clear and type “3.55” into “Gas price” field
        //10. Click on Calculate button
        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
    }


    }
