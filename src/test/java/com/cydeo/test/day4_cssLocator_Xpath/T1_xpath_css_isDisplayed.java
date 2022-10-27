package com.cydeo.test.day4_cssLocator_Xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_css_isDisplayed {
    public static void main(String[] args) {
//        TC #1: XPATH and cssSelector Practices
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//        3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
//        a. “Home” link
        //locate homeLink using xpath
        WebElement homeLink = driver.findElement(By.xpath("//a[@class = 'nav-link']"));   //or "//a[@href = '/']" or "//a[.= 'Home']"

        //locate homeLink using cssSelector, class value
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class = 'nav-link']"));   //or"a.nav-link"


        //locate homeLink using cssSelector, href value
//        WebElement homeLink2 = driver.findElement(By.cssSelector("a[href = '/']"));

//        b. “Forgot password” header using cssSelector
        WebElement forgotPasswordHeader = driver.findElement(By.cssSelector("div[class = 'example']>h2"));//from parent to child using ">"
        //                                                                  Or div.example>h2

       // “Forgot password” header using xpath
        WebElement forgotPasswordHeader1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

//        c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for = 'email']"));

        // E-mail text using xpath
        WebElement emailText1 = driver.findElement(By.xpath("//label[@for='email']"));

//        d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type = 'text']"));

        // E-mail input box using xpath
        WebElement emailInputBox1 = driver.findElement(By.cssSelector("//input[@type='text']"));


//        e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("i[class = 'icon-2x icon-signin']")); //or button#form_submit  //or button.radius


//        f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style = 'text-align: center;']"));

//        4. Verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());

    }
}
