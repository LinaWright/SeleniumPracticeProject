package com.cydeo.homework;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9Homework1 extends TestBase {

//    Iframe homework:
//    You can do practice about Iframe from NextBaseCRM --> US2 --> TC1: Verify users can send message by clicking "MESSAGE" tab
//
//    Test cases #1
//    Description:  Users send text messages successfully
//    Environment:  https://login2.nextbasecrm.com/

    @Test
    public void sendMessage() {
        //    Steps::
//    1.  Users are on the homepage (Login with valid username and password)
        driver.get("https://login2.nextbasecrm.com/");
        WebElement userNameInput = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        userNameInput.sendKeys("hr33@cybertekschool.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@type = 'password']"));
        passwordInput.sendKeys("UserUser");

        WebElement logInBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
        logInBtn.click();

//    2.  Users click the MESSAGE tab
        WebElement messageTab = driver.findElement(By.xpath("//span[.='Message']"));
        messageTab.click();
//    3.  Users write test message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement messageBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        messageBox.sendKeys("Hello");

//    4.  Users click the SEND button
        driver.switchTo().parentFrame();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();

//    5.  Verify the message is displayed on the feed
        WebElement message = driver.findElement(By.xpath("//div[@id='blog_post_body_7837']"));
        Assert.assertEquals(message.getText(), "Hello");
    }


//
//    Valid Credentials are in this link:
//    https://learn.cybertekschool.com/courses/740/modules/items/54181

}
