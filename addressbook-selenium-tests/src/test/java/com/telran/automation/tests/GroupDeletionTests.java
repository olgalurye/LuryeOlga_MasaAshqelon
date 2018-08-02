package com.telran.automation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
 public void testGroupDeletion(){
        goToGroupsPage();
 if(!isGroupPresent()){
     createGroup();
 }
        selectGroup();
        clickOnDeleteGroupButton();
        returnToGroupsPage();
    }

    private void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    private void clickOnDeleteGroupButton() {
        wd.findElement(By.name("delete")).click();
    }


}
