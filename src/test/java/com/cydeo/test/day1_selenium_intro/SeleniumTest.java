package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SeleniumTest {
    public static void main(String[] args) {
        //1- setting up the web driver manager
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:/Users/linal/Desktop/HTML Class/chromedriver");
        //2- create instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //driver.get(url)
        driver.get("http://www.google.com");


    }
}
