package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
//1. Open browser

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void informationAlertTest() {
//3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[. = 'Click for JS Alert']"));
        jsAlertBtn.click();

//4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultTest = driver.findElement(By.id("result"));

        //assertTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultTest.isDisplayed());

        String actualResultTest = resultTest.getText();
        String exceptResultTest = "You successfully clicked an alert";
        Assert.assertEquals(actualResultTest,exceptResultTest,"Result text test failed");
    }
}
