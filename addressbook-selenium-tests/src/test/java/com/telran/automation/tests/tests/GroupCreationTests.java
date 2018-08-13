package com.telran.automation.tests.tests;

import com.telran.automation.tests.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test(priority = 1)
    public void testGroupCreation() {
        app.getGroupHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();   // размер количества групп
        app.getGroupHelper().initiateGroupCreation();
        app.getGroupHelper().fillGroupForm(new Groups().withName("testGroupooooooo")
                .withHeader("testHeader")
                .withFooter("testFooter"));
        app.getGroupHelper().submitInformation();
        app.getGroupHelper().returnToGroupsPage();
        app.getGroupHelper().createGroup();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);   // проверяем, что групп стало на 1 больше (сравнение actual и ожидаемое)
    }

    @Test(priority = 2)
    public void testGroupWithLongNameCreation() {

        app.getGroupHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initiateGroupCreation();
        app.getGroupHelper().fillGroupForm(new Groups().withName("test1")
                .withHeader("testHeader1")
                .withFooter(""));
        app.getGroupHelper().submitInformation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        System.out.println("count before:" + before + "; count after creation is: " + after);
        Assert.assertEquals(after, before + 1);
    }

    @Test(enabled = false, priority = 3)
    public void testGroupWithEmptyFieldsCreation() {
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().createGroup();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }


}
