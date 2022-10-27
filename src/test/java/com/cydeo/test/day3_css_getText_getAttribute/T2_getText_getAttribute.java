package com.cydeo.test.day3_css_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
//        TC #5: getText() and getAttribute() method practice
//        1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

//        2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

//        3- Verify header text is as expected:
//        Expected: Registration form

        //locate hearderText to get text between opening and closing tag
        WebElement headerText = driver.findElement(By.tagName("h2"));
        //We can also use cssSelector to go from parent to child

        String exceptedHeader = "Registration form";
        String actualHeader = headerText.getText();

        if(actualHeader.equals(exceptedHeader)){
            System.out.println("header text verification passed!");
        }else{
            System.out.println("header text verification failed!");
        }

//        4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.className("form-control"));

//        5- Verify placeholder attribute’s value is as expected:
//        Expected: first name
        String excepted = "first name";
        String actual = firstNameInput.getAttribute("placeholder");
        System.out.println(actual);
        //getAttribute(attribute argument) method is helping us to get value of attributes

        if(excepted.equals(actual)){
            System.out.println("Placeholder text verification passed!");
        }else{
            System.out.println("Placeholder text verification failed!");
        }

        driver.quit();
    }
}
