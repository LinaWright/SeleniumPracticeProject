package com.cydeo.test.day10_utilities_windows;

import com.cydeo.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Iframe_CRM_AppreciationTest extends TestBase {
    @Test
    public void sendingAppreciationMsg() {

//        TC  #1: Iframe Task
//1- Open a chrome browser    It's done in the TestBase
//2- Go to:  https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/ ");
        CRM_Utilities.login_crm(driver);
//3- Login Homepage ( Login with valid username and password)
//        WebElement userName = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
//        userName.sendKeys("hr33@cybertekschool.com");
//        WebElement password = driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']"));
//        password.sendKeys("UserUser");
//        WebElement loginBtn = driver.findElement(By.cssSelector("input[class = 'login-btn']"));
//        loginBtn.click();

//4- Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.cssSelector("span[id$='link-text']"));
        moreBtn.click();
        WebElement appreciationBtn = driver.findElement(By.xpath("//span[. ='Appreciation']"));
        appreciationBtn.click();

//5- Write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.tagName("body")).sendKeys("Hello!");

//6- Click the SEND button
        driver.switchTo().parentFrame();
        driver.findElement(By.id("blog-submit-button-save")).click();

//7- Verify the Appreciation message is displayed on the feed
        WebElement feedText = driver.findElement((By.xpath("//div[starts-with(@id,'blog_post_body')]")));
        String actualText = feedText.getText();
        String exceptText = "Hello!";
        Assert.assertEquals(actualText, exceptText, "Feed message did not appear correctly");
    }
}
