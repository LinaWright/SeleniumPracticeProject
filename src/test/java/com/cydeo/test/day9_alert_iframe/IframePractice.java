package com.cydeo.test.day9_alert_iframe;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {
    @Test
    public void iFrameTest (){
//        TC #6: Iframe Task
//    1- Open a chrome browser
        //since that I inherited the TestBase, I don't have to set up the webdriver anymore

//    2- Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        //frame(id)
        driver.switchTo().frame("mce_0_ifr");

//    3- Clear text from comment body
        WebElement commentBody = driver.findElement(By.id("tinymce"));
        //NoSuchElementException comes with reason: 1. Not locating correctly element; 2.There os an iframe and you have to switch to iframe

        //frame(locator)
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'mce_0_ifr']")));

        //frame(index) -> index starts from 0
        //We can find iframe from html with using xpath "//iframe"
//        driver.switchTo().frame(0);


        commentBody.clear();//delete text from comment body

//    4- Type "Hello World" in comment body
        commentBody.sendKeys("Hello World");

//    5- Verify "Hello World" text is written in comment body
        Assert.assertEquals(commentBody.getText(), "Hello World");

//    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
        driver.switchTo().parentFrame(); // -> if you have nested frame and if you want to switch to direct parent

//        driver.switchTo().defaultContent(); ->will switch to main HTML, which is the parent of all HTML

        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed(),"Header text did not appear");

        String actualHeader = headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualHeader,expectedHeader,"Header text did not appear correctly");

    }
}
