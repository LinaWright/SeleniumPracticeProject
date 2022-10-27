package com.cydeo.softskilltask.nadirTask03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.cydeo.softskilltask.nadirTask03.Constance.userNameBoxElement;

public class LogInPage {
    public WebDriver driver;

    private String userNameElement = "input[type='password']";
    private String passWordElement = "input[type = 'submit']";
    private  WebElement authorization;
    private String CRMElement = "//*[@id=\"logo_24_text\"]/span[1]";
    private WebElement logInBtn;
    private  WebElement passWordBox;
    private WebElement userNameBox;

    public LogInPage() {//Constructor
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void logIn(String userName, String passWord) {

        userNameBox = driver.findElement(By.cssSelector(userNameBoxElement));
        userNameBox.sendKeys(userName);

        passWordBox = driver.findElement(By.cssSelector(userNameElement));
        passWordBox.sendKeys(passWord);

        logInBtn = driver.findElement(By.cssSelector(passWordElement));
        logInBtn.click();

    }

    public String getActualMessage(){
        authorization = driver.findElement(By.xpath(CRMElement));
        return authorization.getText();

    }
}
