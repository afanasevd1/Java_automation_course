package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletionGroup() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Name", "header", "footer"));
    }
    int before = app.getGroupHelper().GroupCount();
    app.getGroupHelper().selectGroups(before - 1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().GroupCount();
    Assert.assertEquals(after, before - 1);
  }
}
