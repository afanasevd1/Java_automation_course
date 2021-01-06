package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeletionGroup() {
    app.goToGroupPage();
    app.selectGroups();
    app.deleteGroup();
    app.returnToGroupPage();
  }
}
