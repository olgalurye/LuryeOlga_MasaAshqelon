package com.telRan.automation.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSiteTest extends TestBase {

    @Test
    public void sLabsHomePageOpeningTest(){
       String url = app.getSessionHelper().getUrl();    // getSessionHepler - создали геттер в Application Manager
        Assert.assertEquals(url, "https://s-labs.ru/");
    }

    @Test
    public void logoPresentTest() throws InterruptedException {

        Assert.assertTrue(app.getHeaderPage().isLogoPresent());

    }

}
