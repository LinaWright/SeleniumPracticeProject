package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3Homework1 {
    public static void main(String[] args) {
//        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Verify “remember me” label text is as expected:
//        Expected: Remember me on this computer
        WebElement rememberMeText = driver.findElement(By.cssSelector("label[class = 'login-item-checkbox-label']"));

        String expectedRememberMeText = "Remember me on this computer";
        String actualRememberMeText = rememberMeText.getText();

        if (expectedRememberMeText.equals(actualRememberMeText)) {
            System.out.println("RememberMeText test passed!");
        } else {
            System.out.println("RememberMeText test failed!");
        }

//        4- Verify “forgot password” link text is as expected:
//        Expected: FORGOT YOUR PASSWORD?
        WebElement forgotPasswordText = driver.findElement(By.cssSelector("a[class = 'login-link-forgot-pass']"));

        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordText = forgotPasswordText.getText();

        if (expectedForgotPasswordText.equals(actualForgotPasswordText)) {
            System.out.println("ForgotPasswordText test passed");
        } else {
            System.out.println("ForgotPasswordText test failed");
        }

//        5- Verify “forgot password” href attribute’s value contains expected:
//        Expected: forgot_password=yes
        String exceptedForgotPasswordHrefAttribute = "forgot_password=yes";
        String actualForgotPasswordHrefAttribute = forgotPasswordText.getAttribute("href");

        if(actualForgotPasswordHrefAttribute.contains(exceptedForgotPasswordHrefAttribute)){
            System.out.println("ForgotPasswordHrefAttribute test passed!");
        }else{
            System.out.println("ForgotPasswordHrefAttribute test failed!");
        }

        driver.quit();
//        PS: Inspect and decide which locator you should be using to locate web
//        elements.
    }
}
