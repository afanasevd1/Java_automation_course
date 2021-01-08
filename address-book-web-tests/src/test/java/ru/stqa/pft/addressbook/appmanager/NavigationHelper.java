package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1")) // Не делать перехо, если мы уже на нужной странице
            && wd.findElement(By.tagName("h1")).getText().equals("Group")
            && isElementPresent(By.name("new")) ) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void goToHomePage() { // Не делать перехо, если мы уже на нужной странице
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
