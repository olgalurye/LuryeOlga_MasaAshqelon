package com.telran.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("http://localhost/addressbook/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wd.get("http://localhost/addressbook/") -  аналог navigate to

        login();

    }

    public void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");


        wd.findElementByXPath("//*[@type='submit']").click();
    }

    public void returnToGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
Thread.sleep(6000);
wd.quit();

    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm() {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("Olga");

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("Lurye");

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("Ashkelon");
    }

    protected void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void submitInformation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(String name, String header, String footer) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(name);                // fill group form

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(header);

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void initiateGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean areElementsPresent(By locator){    // работает также, как и isElementPresent
       return wd.findElements(locator).size()>0;
    }


    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
        }

    public void createGroup() {
        initiateGroupCreation();
        fillGroupForm("testGroup", "testHeader", "testFooter");
        submitInformation();
        returnToGroupsPage();
    }

    protected void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void submitGroupModification() {
        wd.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public void initGroupModification() {
        wd.findElementByName("edit").click();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
