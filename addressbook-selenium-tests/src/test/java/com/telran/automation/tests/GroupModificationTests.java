package com.telran.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase  {

    @Test

    public void testGroupModification(){
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroup();

        initGroupModification();
        fillGroupForm("modifyGroup", "modtestHeader", "modtestFooter");
        submitGroupModification();
        returnToGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before);

        
    }


}
