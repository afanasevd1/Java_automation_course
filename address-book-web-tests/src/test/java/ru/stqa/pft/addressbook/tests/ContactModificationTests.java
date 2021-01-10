package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testModificationContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactModification();
    // При передаче null в fillContactForm выпадающий список не заполняем
    app.getContactHelper().fillContactForm(new ContactData(null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
