package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T2_Actions_Scroll {

    @Test
    public void action_scroll_test() {

        //    TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.page.url"));

        //3- Scroll down to “Powered by CYDEO”
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        //4- Scroll using Actions class “moveTo(element)” method

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(cydeoLink).perform();

        //5- Scroll back up to “Home” link using PageUP button
        WebElement homeBtn = Driver.getDriver().findElement(By.linkText("Home"));

        //There are two ways to do scrolling in Action class
        //1.moveToElement(target element)
        //2.keys.Page_UP
        action.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        action.moveToElement(homeBtn).perform();

    }
}
