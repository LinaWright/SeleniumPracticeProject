package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        // set up chrome and create WebDriver instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void  googleTitle(){

        // Get "https://google.com/"
        driver.get("https://google.com/");

        // Assert: title is  "Google"
        String actualTitle = driver.getTitle();
        String expectTitle = "Google";

        //Third argument is optional for failed message, it'll only appear when verification is failed
        Assert.assertEquals(actualTitle,expectTitle,"Title verification failed");

    }

    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com/");
    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com/");
    }
}
