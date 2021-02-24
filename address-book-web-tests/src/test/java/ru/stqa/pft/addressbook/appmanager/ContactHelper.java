package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initCreateContact() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name ("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        if (contactData.getGroup() != null && creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else if (contactData.getGroup() == null && creation) {
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void createNewContact(ContactData contactData) {
        initCreateContact();
        editContactNext();
        fillContactForm(contactData, true); // При передаче null в fillContactForm выпадающий список не заполняем
        submitContactCreation();
        returnToHomePage();
    }

    private void editContactNext() {
        click(By.cssSelector("input[type=\"submit\"]:nth-child(1)"));
    }

    public void modifyById(ContactData contact) {
        initContactModificationById(contact.id);
        // При передаче null в fillContactForm выпадающий список не заполняем
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public Set<ContactData> all() {
        List<WebElement> elements = wd.findElements(By.name("entry"));
        Set<ContactData> contactData = new HashSet<ContactData>();
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String email = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            String phones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            //System.out.println(allPhones);
            contactData.add(new ContactData().withLastName(lastName).withFirstName(firstName).withId(id).withEmail(email)
                .withAddress(address).withAllPhones(allPhones));
        }
        return contactData;
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModificationById(int id) {
        click(By.cssSelector("a[href=\"edit.php?id="+ id + "\"]"));
    }

    public void submitContactModification() {
        click(By.xpath("//body[1]/div[1]/div[4]/form[1]/input[1]"));

    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.id);
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String address = wd.findElement(By.cssSelector("textarea[name=\"address\"]")).getText();
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");

        return new ContactData()
                .withLastName(lastName).withFirstName(firstName).withAddress(address)
                .withEmail(email).withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);






    }
}