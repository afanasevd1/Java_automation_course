package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests  extends TestBase{

  @Test
  public void testCreateContact() {
    app.getContactHelper().createNewContact();
    app.getContactHelper().fillContactForm(new ContactData());
    app.getContactHelper().submitContactCreation();
  }

}
