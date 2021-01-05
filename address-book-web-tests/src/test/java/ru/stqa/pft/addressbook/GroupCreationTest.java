package ru.stqa.pft.addressbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GroupCreationTest {
   FirefoxDriver wd;

  @BeforeClass
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @Test
  public void testGroupCreation() {
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("new")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys("666");
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).sendKeys("777");
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).sendKeys("888");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("group page")).click();
  }
}
