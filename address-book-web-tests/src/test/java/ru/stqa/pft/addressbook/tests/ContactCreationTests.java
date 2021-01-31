package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test (enabled = false)
  public void testCreateContact() {
    app.goTo().goToHomePage();
    int before = app.getContactHelper().getCountContacts();
    app.getContactHelper().createNewContact(new ContactData(null));
    int after = app.getContactHelper().getCountContacts();
    Assert.assertEquals(after, before + 1);

  }

}
