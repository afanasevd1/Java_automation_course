package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("666", "777", "888"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
