package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (!app.contact().isElementPresent(By.name("selected[]"))) {
      app.contact().createNewContact(new ContactData());
    }
  }
  @Test
  public void testModificationContact() {
    Set<ContactData> before = app.contact().all();
    ContactData contctModifeied = before.iterator().next();
    ContactData contact = new ContactData().withId(contctModifeied.getId()).withLastName("Modified Last Name")
            .withFirstName("Modified First Name").withAddress("Modified Address");
    app.contact().modifyById(contact);
    assertEquals(app.contact().count(), before.size());
    before.remove(contctModifeied);
    before.add(contact);
    assertEquals(before, app.contact().all());
  }
}