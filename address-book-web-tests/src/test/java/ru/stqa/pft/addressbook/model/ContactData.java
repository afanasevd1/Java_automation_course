package ru.stqa.pft.addressbook.model;

public class ContactData {

  public String firstName;
  public String lastName;
  public String telephones;
  public String homePhone;
  public String mobilePhone;
  public String workPhone;
  public String email;
  public String group;
  public String address;
  public int id;

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withTelephones(String telephone) {
    this.telephones = telephone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTelephones() {
    return telephones;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public String getAddress() { return address; }

  public int getId() {return id; }

  public String getHomePhone() { return homePhone; }

  public String getMobilePhone() { return mobilePhone; }

  public String getWorkPhone() { return workPhone; }
}