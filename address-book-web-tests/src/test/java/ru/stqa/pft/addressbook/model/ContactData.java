package ru.stqa.pft.addressbook.model;

public class ContactData {

  public String firstName;
  public String lastName;
  public String telephone;
  public String email;
  private String group;


  public ContactData (String group){
    this.group = group;
    this.firstName = "firstName";
    this.lastName = "lastName";
    this.telephone = "telephone";
    this.email = "email";
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTelephone() {
    return telephone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
