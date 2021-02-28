package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    NavigationHelper navigationHelper = new NavigationHelper(wd);


    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {

        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroups(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroups(index);
        deleteGroup();
        returnToGroupPage();
    }

    public void delete(GroupData deletedGroup) {
        selectGroupById(deletedGroup.getId());
        deleteGroup();
        groupCache = null;
        returnToGroupPage();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() throws NumberFormatException {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("input[name=\"selected[]\"]"));
        Set<GroupData> groupDataGroups = elements.stream()
                .map((element) -> (Integer.parseInt(element.getAttribute("value"))))
                .map((i) -> new GroupData().withId(i))
                .collect(Collectors.toSet())
                .stream().map(this::infoFromEditForm)
                //.map(this::infoFromEditForm)
                .collect(Collectors.toSet());
        groupCache.addAll(groupDataGroups);
        return new Groups(groupCache);
    }


    private GroupData infoFromEditForm(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        String name = wd.findElement(By.name("group_name")).getAttribute("value");
        String header = wd.findElement(By.name("group_header")).getText();
        String footer = wd.findElement(By.name("group_footer")).getText();
        navigationHelper.groupPage();

        return group.withName(name).withHeader(header).withFooter(footer);
    }
}
