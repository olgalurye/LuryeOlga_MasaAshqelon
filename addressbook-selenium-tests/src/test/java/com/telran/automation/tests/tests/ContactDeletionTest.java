package com.telran.automation.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase  {
@Test
    public void deleteContact(){
    if(!app.getContactHelper().isOnTheHomePage()){
        app.getContactHelper().goToHomePage();
    }
    if(!app.getContactHelper().isContactPresent()){
        app.getContactHelper().createContact();

    }

    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
       app.getContactHelper().clickOnDeleteContactButton();
       app.getContactHelper().confirmAlert();

       int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before-1);
}


}
