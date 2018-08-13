package com.telran.automation.tests.tests;

import com.telran.automation.tests.Contacts;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {



        @Test
    public void nameCreationTest(){
            if(!app.getContactHelper().isOnTheHomePage()){
                app.getContactHelper().goToHomePage();
            }

            int before = app.getContactHelper().getContactCount();
                        app.getContactHelper().initContactCreation();
            app.getContactHelper().fillContactForm(new Contacts().withFirstName("firstName")
                    .withLastName( "lastName")
                    .withAddress( "Ashkelon")
                    .withAddress( "12345"));
            app.getContactHelper().submitContactCreation();

            int after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before+1);

        }

    @Test
    public void nameCreationTestvv(){
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new Contacts()
                .withFirstName("first1")
                .withLastName("last1")
                .withAddress("address1")
                .withHomePhone("54321"));
        app.getContactHelper().submitContactCreation();


    }


}
