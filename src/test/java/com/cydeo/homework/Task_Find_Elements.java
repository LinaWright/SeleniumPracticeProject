package com.cydeo.homework;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task_Find_Elements extends TestBase {
    @Test
    public void findElements() {

//        TC #1: Checking the number of links on the page
//    1. Open Chrome browser

//    2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");

//    3. Count the number of the links on the page and verify
//    Expected: 332
        List allLinks = driver.findElements(By.tagName("a"));
        Assert.assertEquals(allLinks.size(), "337");
    }

    //    TC #2: Printing out the texts of the links on the page
//    1. Open Chrome browser
//    2. Go to https://www.openxcell.com
//    3. Print out all of the texts of the links on the page
    @Test
    public void printElements() {

//        TC #1: Checking the number of links on the page
//    1. Open Chrome browser

//    2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");

//    3. Count the number of the links on the page and verify
//    Expected: 332

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List<String> linkText = new ArrayList<>();
        for (int i = 0; i < allLinks.size(); i++) {
            try {
                linkText.add(allLinks.get(i).getText());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int hasTextCount = 0;
        for (int i = 0; i < linkText.size(); i++) {
            if (!linkText.get(i).isBlank() && !linkText.get(i).isEmpty() && linkText.get(i) != null) {
                System.out.println(linkText.get(i));
                hasTextCount++;
            }
        }
        System.out.println("Number of links which have visible text " + hasTextCount + ".");
    }

//    TC #3: Counting the number of links that does not have text
//    1. Open Chrome browser
//    2. Go to https://www.openxcell.com
//    3. Count the number of links that does not have text and verify
//    Expected: 109
        @Test
        public void countAllLinks() {
            //1. Open Chrome browser
//2. Go to https://www.openxcell.com
            driver.get("https://www.openxcell.com");
//   3. Count the number of links that does not have text
//    Expected: 109.
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("Number of all links in the page: " + allLinks.size());//337
            //I ll try to getText() from each of the links and catch possible exceptions,
            // save results into String list
            List<String>linkText=new ArrayList<>();
            for (int i = 0; i <allLinks.size() ; i++) {
                try { linkText.add(allLinks.get(i).getText());
                }catch (Exception e){
                    System.out.println(e.getMessage());}}
            //If linkText string is blank or empty - this link does not have text.
            List <String> noText=new ArrayList<>();
            int actualNumberNoTextLinks=0;
            for (int i = 0; i <linkText.size() ; i++) {
                if(linkText.get(i).isBlank()||linkText.get(i).isEmpty()||linkText.get(i)==null) {
                    actualNumberNoTextLinks++;}}
            int expectedNumberNoTextLinks=109;
            Assert.assertTrue(actualNumberNoTextLinks==expectedNumberNoTextLinks,"No text link number verification is failed! Actual number or no text links is " + actualNumberNoTextLinks+".");

//
//    NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
//    FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
//    IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
//    VERIFICATION.
    }
}
