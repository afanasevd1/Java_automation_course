package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().GroupCount();
    app.getGroupHelper().createGroup(new GroupData("666", "777", null));
    int after = app.getGroupHelper().GroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
