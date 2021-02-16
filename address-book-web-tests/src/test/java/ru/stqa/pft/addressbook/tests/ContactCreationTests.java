package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {


  @Test ()
  public void testCreateContact() {
    app.goTo().homePage();
    int before = app.contact().count();
    app.contact().createNewContact(new ContactData().withFirstName("Dima").withLastName("Afanasev")
    .withAddress("Yekaterinburg").withHomePhone("111").withWorkPhone("222").withMobilePhone("333").withEmail("t1@t.ru"));
    int after = app.contact().count();
    assertEquals(after, before + 1);
  }
}