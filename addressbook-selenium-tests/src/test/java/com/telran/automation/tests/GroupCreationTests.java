package com.telran.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test(priority = 1)
    public void testGroupCreation() {
        goToGroupsPage();
        int before = getGroupsCount();   // размер количества групп

        initiateGroupCreation();
        fillGroupForm("testGroup", "testHeader", "testFooter");
        submitInformation();
        returnToGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before + 1);   // проверяем, что групп стало на 1 больше (сравнение actual и ожидаемое)
    }

    @Test(priority = 2)
    public void testGroupWithLongNameCreation() {

        goToGroupsPage();
int before = getGroupsCount();
        initiateGroupCreation();
        fillGroupForm("testGroupooooooo", "testHeader", "testFooter");
        submitInformation();
        returnToGroupsPage();
        int after = getGroupsCount();
        System.out.println("count before:" + before + "; count after creation is: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test(enabled = false, priority = 3)
    public void testGroupWithEmptyFieldsCreation() {
        int before = getGroupsCount();
        goToGroupsPage();
        initiateGroupCreation();
        fillGroupForm("testGroup", "testHeader", "testFooter");
        submitInformation();
        returnToGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }


}
