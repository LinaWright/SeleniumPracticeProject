package com.cydeo.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Creating a private constructor, we care closing access to the object of this class from outside the class
    private Driver() {

    }
    //We make Webdriver private, because we want to class access from outside the class
    //We make it static, because we will use it inside static method

    //Using static here, because we can call it using class name
    private static WebDriver driver; //value is null by default;

    //Create a re-usable util method which will return same driver instance when we call it
    public static WebDriver getDriver() {
        //it will check if the driver is null, if it's null, we will set up the browser inside if statement
        //If you already set up driver and using it again for following line of codes, it'll return to same driver
        if (driver == null) {
            //We read browserType from configuration.properties with the help of ConfigurationReader class getProperty()method
            String browserType = ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }
//This method will make sure our driver valur is always null after using quit() method
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();//This kine will terminate the exiting driver session, with using this driver will not be null.
            driver=null; //reassign null to driver
        }
    }
}
