package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createNewContact(){
    click(By.xpath("//a[contains(text(),'add new')]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());
    if (contactData.getGroup() != null){
     if (creation) {
       new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());}
     }
    if (contactData.getGroup() == null){
      if (creation) {
      } else { Assert.assertFalse(isElementPresent(By.name("new_group"))); }
   }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactModification() {
    click(By.xpath("//tbody/tr[2]/td[8]/a[1]/img[1]"));
  }

  public void submitContactModification() {
    click(By.xpath("//body[1]/div[1]/div[4]/form[1]/input[1]"));

  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

}


