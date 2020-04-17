package com.cpn.aiithire.lnkinservice.domain.model.entity;

public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    public BaseEntity(String name) {
        super.name = name;
        isModified = false;
    }

    public boolean isIsModified() {
        return isModified;
    }

}
