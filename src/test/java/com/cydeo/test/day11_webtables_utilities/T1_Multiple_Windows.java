package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_Multiple_Windows extends TestBase {
    @Test
    public void windowsHandleTest(){
    //    TC #2: Window Handle practice
    //1. Create new test and make setups
    //2. Goto:https://www.amazon.com
        driver.get("https://www.amazon.com");

    //3. Copy and paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //"_blank" will open url in new tab/window

//    //4. Create a logic to switch to the tab where Etsy.com is open 5. Assert:Title contains“Etsy”
//        Set<String>allWindowHandles = driver.getWindowHandles(); //We store all windows in set of String with using getWindowHandles() method
//        for (String each : allWindowHandles) {
//            driver.switchTo().window(each); //will switch each windows and driver will be able to see each window
//            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
//            if(driver.getCurrentUrl().contains("etsy")){
//                break;
//            }
//        }
//    //5. Assert:Title contains “Etsy”
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Etsy";
//        Assert.assertTrue(actualTitle.contains(expectedTitle));

        BrowserUtils.switchWindowAndVerify(driver,"esty","Etsy");

    }




}
