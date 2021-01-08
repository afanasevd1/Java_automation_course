package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletionGroup() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Name", "header", "footer"));
    }
    app.getGroupHelper().selectGroups();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
