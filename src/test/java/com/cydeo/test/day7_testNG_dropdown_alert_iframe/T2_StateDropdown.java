package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T2_StateDropdown {
    private WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
//        1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

//        2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void stateDropdownTest() {
//        3. Select Illinois
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        stateDropdown.selectByValue("IL");

//        4. Select Virginia
        stateDropdown.selectByVisibleText("Virginia");

//        5. Select California
        stateDropdown.selectByIndex(5);

//        6. Verify final selected option is California.

        //getFirstSelectedOption() will return current selected option.
        String actualStateOption = stateDropdown.getFirstSelectedOption().getText();
        String exceptStateOption = "California";
        Assert.assertEquals(actualStateOption, exceptStateOption,"Selected option verification failed");
//        Use all Select options. (visible text, value, index)

    }

    @Test
    public void multiselectDropdownTest(){
//        3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));

//       isMultiple()  will return true if dropdown has multiple options
        System.out.println("languages.isMultiple() = " + languages.isMultiple());

//        4. Print out all selected values.

        //getOptions() method will return all options in dropdown
        List <WebElement> allOptions = languages.getOptions();

        for(WebElement each : allOptions){
            each.click();
            System.out.println("each.getText() = " + each.getText());
        }

//        5. Deselect all values.
        languages.deselectAll();

    }

}
