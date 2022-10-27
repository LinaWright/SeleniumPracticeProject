package com.cydeo.softskilltask.nadirTask03;

import org.junit.Assert;

import static com.cydeo.softskilltask.nadirTask03.Constance.*;

public class T03_AutomateTC {
    public static void main(String[] args) {
         LogInPage myLogInPage = new LogInPage();

        myLogInPage.driver.get(environment);

        myLogInPage.logIn(userName,password);

        Assert.assertEquals(myLogInPage.getActualMessage(),exceptedCRMTextMessage);//What we use right now is if statement

        myLogInPage.driver.quit();
    }


}
