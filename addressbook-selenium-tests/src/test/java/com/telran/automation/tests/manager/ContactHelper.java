package com.telran.automation.tests.manager;

import com.telran.automation.tests.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactHelper extends HelperBase{

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillContactForm(Contacts contacts) {
        type(By.name("firstname"), contacts.getFirstName());
        type(By.name("lastname"), contacts.getLastName());
        type(By.name("address"), contacts.getAddress());
        type(By.name("home"), contacts.getHomePhone());
    }



    public void type(By locator,  String text) {
        if(text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }



    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    public void selectContact() {
        click(By.name("selected[]"));
    }


    public void clickOnDeleteContactButton() {
        wd.findElementByXPath("//*[@value='Delete']").click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));

    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new Contacts().withFirstName("firstName").withLastName( "lastName").withAddress( "address").withHomePhone( "12345"));
        submitContactCreation();
    }

    public boolean isOnTheHomePage() {
        return isElementPresent(By.id("maintable"));

    }

    public void goToHomePage() {
       click(By.xpath("//a[@href='./']"));
    }

    public void initEditContactByClickingOnThePencil() {
        click(By.xpath("//*[@title = 'Edit']"));
    }

    public void confirmContactModification() {
        click(By.xpath("//input[@value = 'Update']"));

    }
}
