package ru.stqa.pft.addressbook.model;

public class ContactData {

  public String firstName;
  public String lastName;
  public String telephone;
  public String email;


  public ContactData (){

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
}
