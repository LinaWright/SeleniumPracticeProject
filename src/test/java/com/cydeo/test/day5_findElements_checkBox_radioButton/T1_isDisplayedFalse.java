package com.cydeo.test.day5_findElements_checkBox_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_isDisplayedFalse {
    public static void main(String[] args) {
//        1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://www.tesla.com/
        driver.get("https://www.tesla.com/");

//        3- Locate Solar Panels header
        WebElement solarPanelsHeader = driver.findElement(By.xpath("(//h1[contains(@class, 'homepage-hero')])[6]"));

//        4- Verify if it is dispayed on the page
        System.out.println("solarPanelsHeader.isDisplayed() = " + solarPanelsHeader.isDisplayed());


    }
}
