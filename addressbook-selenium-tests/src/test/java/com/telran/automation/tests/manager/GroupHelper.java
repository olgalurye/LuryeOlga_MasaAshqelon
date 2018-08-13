package com.telran.automation.tests.manager;

import com.telran.automation.tests.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void fillGroupForm(Groups group) {
        type(By.name("group_name"), group.getName());

        type(By.name("group_header"), group.getHeader());

        type(By.name("group_footer"), group.getFooter());
    }

    public void type(By locator, String text) {
        // если заданный текст для заполнения не Null, то мы его заполняем. Если ничего - то просто остается пустое поле (передаем Null)
        if (text != null) {

            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }



    public void initiateGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
        }

    public void createGroup() {
        initiateGroupCreation();
        fillGroupForm(new Groups().withName("testGroup").
                withHeader( "testHeader").
                withFooter( "testFooter"));
        submitInformation();
        returnToGroupsPage();
    }

    public void selectGroup() {
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

    public void submitInformation() {
        wd.findElement(By.name("submit")).click();
    }
    public void clickOnDeleteGroupButton() {
        wd.findElement(By.name("delete")).click();
    }


}
