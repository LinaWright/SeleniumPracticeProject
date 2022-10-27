package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Simple_DropDown {
    // TC #1: Verifying “Simple dropdown” and “State selection”
    //dropdown default values
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void simpleDropDownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));

        //getFirstSelectedOption() method will return to default selected option, return type is webElement
        String actualDefaultSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String exceptDefaultSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultSimpleDropdown,exceptDefaultSimpleDropdown);

    }

    @Test
    public void stateDropdownTest(){
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        String actualStateDefaultText = stateDropdown.getFirstSelectedOption().getText();
        String exceptStateDefaultText = "Select a State";

        Assert.assertEquals(actualStateDefaultText,exceptStateDefaultText);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
