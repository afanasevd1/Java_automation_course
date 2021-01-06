package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletionGroup() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroups();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
