package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4HomeWork2 {
    public static void main(String[] args) {

//    TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
//1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

//3- Enter incorrect username into login box:
        WebElement userLoginBox = driver.findElement(By.cssSelector("input[name = 'USER_LOGIN']"));
        userLoginBox.sendKeys("helpdesk34@cybertek.com");

// 4- Click to `Reset password` button
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class = 'login-btn']"));
        resetPasswordButton.click();

//5- Verify “error” label is as expected
//    Expected: Login or E-mail not found
        WebElement errorMessage = driver.findElement(By.cssSelector("div[class = 'errortext']"));
        String exceptedErrorMessage = "Login or E-mail not found";
        String actualErrorMessage = errorMessage.getText();
        if (actualErrorMessage.equals(exceptedErrorMessage)) {
            System.out.println("ErrorMessage test passed!");
        } else {
            System.out.println("ErrorMessage test failed!");
        }

        driver.quit();

//    PS: Inspect and decide which locator you should be using to locate web
//    elements.
//            PS2: Pay attention to where to get the text of this button from
    }
}