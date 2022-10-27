package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P13_LocateElementByCSS {
    private static WebDriver.Options manage;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        //search for cydeo
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
        searchBox.sendKeys("cydeo" + Keys.ENTER);

        //Verify Cydeo LinkText os appeared in the results
        WebElement cydeoText = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']>h3"));

        //What Is getText() Method? The Selenium WebDriver interface has predefined the getText() method, which helps retrieve the text for a specific web element. This method gets the visible, inner text (which is not hidden by CSS) of the web-element.
        if(cydeoText.getText().equals("Cydeo")){
            System.out.println("Cydeo text test is passed");
        }else{
            System.out.println("Cydeo text test is failed");
        }

        driver.quit();

    }
}
