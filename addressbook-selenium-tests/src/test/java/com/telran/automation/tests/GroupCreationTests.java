package com.telran.automation.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        // go to groups page
        goToGroupsPage();    // go to groups page
        initiateGroupCreation();
        fillGroupForm();
        submitInformation();
        returnToGroupsPage();


    }


}
