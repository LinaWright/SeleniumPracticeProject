package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1_Guru99_DragAndDrop_Test {
    @Test
    public void guru_dragAndDrop_test() {

//        TC : Guru99 Drag and Drop Test
//    1- Open a chrome browser
//    2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.dropdown.url"));
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank,debitAccount).perform();

//    3- Drag “BANK” and drop into Account area under Debit
//    Side
        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amount = Driver.getDriver().findElement(By.id("amt7"));

//    4- Drag “5000” and drop into Amount area under Debit Side
        actions.dragAndDrop(fiveK,amount).perform();

//    5- Drag “SALES” and drop into Account area under Credit
//    Side
//    6- Drag “5000” and drop into Amount area under Credit
//    Side
//    7- Verify “Perfect!” text displayed.

    }
}
