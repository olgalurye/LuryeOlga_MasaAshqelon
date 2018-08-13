package com.telran.automation.tests.tests;

import com.telran.automation.tests.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModification() {
        app.getGroupHelper().goToGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();

        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Groups().withName("modifyGroup").withHeader("modtestHeader").withFooter("modtestFooter"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before);


    }


}
