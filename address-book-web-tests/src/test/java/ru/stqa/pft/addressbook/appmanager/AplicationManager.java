package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AplicationManager {

  public WebDriver wd;
  public GroupHelper groupHelper;
  public NavigationHelper navigationHelper;
  public SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  protected String browser;

  public AplicationManager(String browser) {

    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);

    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
