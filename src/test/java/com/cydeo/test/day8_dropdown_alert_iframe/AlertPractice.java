package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertPractice {
    /*
    TC #2: Confirmation alert practice
     */

    private WebDriver driver;
    //    TC : Selecting date on dropdown and verifying
    @BeforeMethod
    public void setUpMethod() {
//    1. Open browser
//    2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cydeo.com/javascript_alerts ");
    }

    @Test
    public void confirmAlertTest(){
//        3. Click to “Click for JS Confirm” button
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertBtn.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //for clicking cancel button in JS, we can use dismiss() method ->alert.dismiss();

//        5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        assertTrue(resultText.isDisplayed(),"Result text did not appear");

//        Assert.assertEquals(resultText.getText(),"You clicked: Ok");
        String actualText = resultText.getText();
        String exceptText = "You clicked: Ok";
        assertEquals(actualText,exceptText,"Result text did not appear correctly");
    }

        @Test
        public void promptAlertTest(){
    //3. Click to “Click for JS Prompt” button
            WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']"));
            jsPrompt.click();

    //4. Send “hello” text to alert
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("hello");


    //5. Click to OK button from the alert
            alert.accept();

    //6. Verify “You entered:  hello” text is displayed.
            WebElement resultText = driver.findElement(By.xpath("//p[@id = 'result']"));
            assertTrue(resultText.isDisplayed(),"Result text did not appear");

//        Assert.assertEquals(resultText.getText(),"You clicked: Ok");
            String actualText = resultText.getText();
            String exceptText = "You entered: hello";
            assertEquals(actualText,exceptText,"Result text did not appear correctly");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
