package com.cpn.aiithire.lnkinservice.domain.model.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public abstract class Entity<T> {

    @Id
    @GeneratedValue
    T id;
    String name;

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
