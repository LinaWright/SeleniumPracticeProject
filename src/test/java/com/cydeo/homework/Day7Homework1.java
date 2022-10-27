package com.cydeo.homework;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day7Homework1 {
    private WebDriver driver;
    //    TC : Selecting date on dropdown and verifying
    @BeforeMethod
    public void setUpMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void selectDate() throws InterruptedException {

        //3. Select “December 1st, 1923” and verify it is selected.
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("1923");

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("December");

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);

        String actualYearText = year.getFirstSelectedOption().getText();
        String expectedYearText = "1923";
        Assert.assertEquals(actualYearText,expectedYearText);

        String actualMonthText = month.getFirstSelectedOption().getText();
        String expectedMonthText = "December";
        Assert.assertEquals(actualMonthText,expectedMonthText);

        String actualDayText = day.getFirstSelectedOption().getText();
        String expectedDayText =  "1";
        Assert.assertEquals(actualDayText,expectedDayText);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


// Select year using   : visible text
//Select month using    : value attribute Select
//day using : index number

}
