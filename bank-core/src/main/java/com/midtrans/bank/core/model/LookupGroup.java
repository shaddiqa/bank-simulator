package com.midtrans.bank.core.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/3/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class LookupGroup {
    private Long id;

    private boolean active;

    private String description;

    private boolean editable;

    private String name;

    private boolean viewable;

    private Set<Lookup> lookups = new HashSet<Lookup>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isViewable() {
        return viewable;
    }

    public void setViewable(boolean viewable) {
        this.viewable = viewable;
    }

    public Set<Lookup> getLookups() {
        return lookups;
    }

    public void setLookups(Set<Lookup> lookups) {
        this.lookups = lookups;
    }
}
