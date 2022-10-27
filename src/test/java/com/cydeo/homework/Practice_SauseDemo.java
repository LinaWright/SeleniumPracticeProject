package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice_SauseDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        WebElement inputName = driver.findElement(By.id("user-name"));
        inputName.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.submit();

        WebElement firstProductLink = driver.findElement(By.linkText("Sauce Labs Backpack"));
        firstProductLink.getAttribute("id");
        WebElement firstProductLink1 = driver.findElement(By.className("inventory_item_name"));
        System.out.println("firstProductLink1.getText() = " + firstProductLink1.getText());

        List<WebElement>allProduct = driver.findElements(By.className("inventory_item_name"));
        System.out.println("allProduct.size() = " + allProduct.size());
        for (WebElement eachProductText:allProduct) {
            String ProductTitle = eachProductText.getText();
            System.out.println("ProductTitle = " + ProductTitle);
        }
        Thread.sleep(2000);
        WebElement sauceLbsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLbsBackpack.click();
        Thread.sleep(2000);
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();
        Thread.sleep(2000);
        WebElement removeItem = driver.findElement(By.xpath("//button[@id = 'remove-sauce-labs-backpack']"));
        removeItem.click();
        Thread.sleep(2000);
        WebElement continueShopping = driver.findElement(By.xpath("//button[@id = 'continue-shopping']"));
        continueShopping.click();

        driver.quit();

    }
}
