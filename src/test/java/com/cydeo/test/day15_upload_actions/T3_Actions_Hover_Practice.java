package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T3_Actions_Hover_Practice {
    @Test
    public void google_actions_hover_test(){

//        TC : Google hover over test
//
//    1. Go to  https://www.google.com
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

//    2. Hover over on Search button
        WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(searchBtn).perform(); //hover over action

//    3. Hover over on Feeling Lucky button
        WebElement fellingLuckyBtn = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));
        actions.moveToElement(fellingLuckyBtn).perform(); //hover over action

    }
}
