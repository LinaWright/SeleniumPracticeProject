package com.cydeo.softskilltask.VyTrack04;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T01 extends TestBase {
    /*


    Truck Drivers 	user48 , user49 , user50	password: UserUser123
    https://qa2.vytrack.com/user/login


     */

    @Test
    public void truckDriverLogin (){
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement logIn = driver.findElement(By.xpath("//input [@id='prependedInput']"));
        logIn.sendKeys("user48");

        WebElement password = driver.findElement(By.xpath("//input [@id='prependedInput2']"));
        password.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

//    "1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page. -- True
        Select fleetDropDown = new Select(driver.findElement(By.xpath("//span[@class='title title-level-1']")));
        fleetDropDown.selectByValue("Vehicles");

//    2.Verify that when user clicks on any car on the grid , system should display general information
//    about the car
//    3.Verify that truck driver can add Event and it should display under Activity tab and General
//    information page as well .
//    4.Verify that Truck driver can reset the setting"
    }
}
