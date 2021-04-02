package ru.stqa.pft.addressbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonIgnoreProperties({"delegate", "empty"})

@Entity
@Table(name = "group_list")
public class GroupData extends Groups {
    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int id;

    @Column(name = "group_name")
    private String name;

    @Column(name = "group_header")
    @Type(type = "text")
    private String header;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, header, footer);
    }

    @Column(name = "group_footer")
    @Type(type = "text")
    private String footer;

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}