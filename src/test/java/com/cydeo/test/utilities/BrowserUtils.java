package com.cydeo.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    /*
    TC : Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Multiple Windows logic re-usable 3. When method is called, it should switch window and verify
title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrlContains, String expectedTitle){

        Set<String> allWindowHandles = driver.getWindowHandles(); //We store all windows in set of String with using getWindowHandles() method
        for (String each : allWindowHandles) {
            driver.switchTo().window(each); //will switch each window and driver will be able to see each window
//            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains(expectedTitle)){
                break;
            }
        }

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
