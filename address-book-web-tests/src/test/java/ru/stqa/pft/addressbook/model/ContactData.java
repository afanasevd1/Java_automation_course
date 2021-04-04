package ru.stqa.pft.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Getter
@With
@AllArgsConstructor
@NoArgsConstructor

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

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

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