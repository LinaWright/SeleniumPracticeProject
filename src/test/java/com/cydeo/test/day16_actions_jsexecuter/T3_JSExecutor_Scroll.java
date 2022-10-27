package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_JSExecutor_Scroll {
    @Test
    public void etsy_scroll_test(){
//        TC : Etsy Scroll down test
//        1. Go to https://www.etsy.com
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
        Actions actions = new Actions(Driver.getDriver());

//        2. Scroll down
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //window.scrollBy(x,y); x(right,left) stand for horizontal line and y stands for vertical lin(up or down)
        //js.executeScript("window.scrollBy(0,5000)"); //do down
        WebElement email = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);
        //js.executeScript("arguments[0].scrollIntoView(true)",email,email1,email2) ==> arguments[0], 0 stands for index of email

//        3. Generate random email and enter into subscribe box
//        4. Click on Subscribe
        Faker faker = new Faker();
        email.sendKeys(faker.internet().emailAddress()+ Keys.ENTER);

//        5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
        WebElement resultMsg = Driver.getDriver().findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        Assert.assertEquals(resultMsg.getText(),"Great! We've sent you an email to confirm your subscription.");
    }
}
