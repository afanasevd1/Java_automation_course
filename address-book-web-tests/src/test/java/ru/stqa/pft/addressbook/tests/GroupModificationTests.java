package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Create", "sdfdsf", "sdf"));
    }
    app.getGroupHelper().selectGroups();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("222", "333", "444"));
    app.getGroupHelper().submitGroupModification();
  }

}
