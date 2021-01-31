package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testModificationContact() {
    app.goTo().goToHomePage();
    if (!app.getContactHelper().isElementPresent(By.name("selected[]"))) {
      app.getContactHelper().createNewContact(new ContactData(null));
    }
    int before = app.getContactHelper().getCountContacts();
    app.getContactHelper().initContactModification();
    // При передаче null в fillContactForm выпадающий список не заполняем
    app.getContactHelper().fillContactForm(new ContactData(null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getCountContacts();
    Assert.assertEquals(after, before);
  }

}
