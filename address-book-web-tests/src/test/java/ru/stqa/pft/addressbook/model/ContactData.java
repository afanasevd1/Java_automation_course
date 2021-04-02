package ru.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column(name = "id")
  public int id;

  @Column(name = "firstname")
  public String firstName;

  @Column(name = "lastname")
  public String lastName;

  @Column(name = "home")
  @Type(type = "text")
  public String homePhone;

  @Column(name = "mobile")
  @Type(type = "text")
  public String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  public String workPhone;

  @Transient
  private String group;

  @Transient
  public String allPhones;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "email")
  @Type(type = "text")
  private String email;

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }



  public File getPhoto() { return new File(photo);  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

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

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
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

  public String getGroup() {
    return group;
  }

  public int getId() {return id; }

  public String getHomePhone() { return homePhone; }

  public String getMobilePhone() { return mobilePhone; }

  public String getWorkPhone() { return workPhone; }

  public String getAllPhones() { return allPhones; }

  public String getAddress() { return address; }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", group='" + group + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", photo='" + photo + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

}