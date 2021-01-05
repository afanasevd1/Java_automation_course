package ru.stqa.pft.addressbook;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  FirefoxDriver wd;

  @BeforeClass
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  @AfterTest
  public void tearDown() {
    wd.quit();
  }

  protected void login(String login, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys(login);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  protected void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  protected void deleteGroup() {
    wd.findElement(By.name("delete")).click();
  }

  protected void selectGroups() {
    wd.findElement(By.name("selected[]")).click();
  }
}
