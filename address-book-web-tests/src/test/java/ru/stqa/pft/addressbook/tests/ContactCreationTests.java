package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests  extends TestBase{

  @Test
  public void testCreateContact() {
    app.getContactHelper().createNewContact();
    // При передаче null в fillContactForm выпадающий список не заполняем
    app.getContactHelper().fillContactForm(new ContactData(null), true);
    app.getContactHelper().submitContactCreation();
  }

}
