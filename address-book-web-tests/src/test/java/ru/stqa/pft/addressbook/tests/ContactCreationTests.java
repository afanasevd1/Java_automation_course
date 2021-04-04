package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreateContact() {
        app.goTo().homePage();
        int before = app.contact().count();
        File photo = new File("src/test/resources/stru.png");
        app.contact().initCreateContact();
        app.contact().fillContactForm(new ContactData().withFirstName("Dima").withLastName("Afanasev")
                .withAddress("Yekaterinburg").withHomePhone("111").withWorkPhone("222").withMobilePhone("333").withEmail("t1@t.ru")
                .withPhoto(photo).withGroup("Name"), true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        int after = app.contact().count();
        assertEquals(after, before + 1);

    }

    @Test
    public void testCurrentDir() {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}