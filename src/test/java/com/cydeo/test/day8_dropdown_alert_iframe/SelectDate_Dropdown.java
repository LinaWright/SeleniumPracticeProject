package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDate_Dropdown {
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
    public void dateDropdownTest() {

//        3. Select “December 1, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));

        for (WebElement eachYearOption : yearDropdown.getOptions()) {
            System.out.println(eachYearOption.getText());
        }


//                Select year using   : visible text
        yearDropdown.selectByVisibleText("1923");

//        Select month using    : value attribute Select
        monthDropdown.selectByValue("11");

//        day using : index number
        dayDropdown.selectByIndex(0);

        // Verify(Assertion) each year, month and day selected correctly
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertTrue(actualYear.equals(expectedYear), "Year selection did not pass!");
        Assert.assertTrue(actualMonth.equals(expectedMonth), "Month selection did not pass!");
        Assert.assertTrue(actualDay.equals(expectedDay), "Day selection did not pass!");

//        Assert.assertEquals(actualYear,expectedYear,"Year selection did not pass!");
//        Assert.assertEquals(actualMonth,expectedMonth,"Month selection did not pass!");
//        Assert.assertEquals(actualDay,expectedDay,"Day selection did not pass!");


    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
