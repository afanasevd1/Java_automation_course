package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.HashSet;
import java.util.Set;


public class Groups extends ForwardingSet<GroupData> {
    @XStreamOmitField
    public Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    public Set<GroupData> delegate() {
        return delegate;
    }

    public Set<GroupData> getDelegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
