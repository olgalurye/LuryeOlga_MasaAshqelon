package com.telran.automation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NameCreationTests extends TestBase {



        @Test
    public void nameCreationTest(){
            initContactCreation();
            fillContactForm();
            submitContactCreation();


        }


}
