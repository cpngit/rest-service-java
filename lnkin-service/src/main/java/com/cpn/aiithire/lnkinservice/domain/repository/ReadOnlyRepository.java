package com.cpn.aiithire.lnkinservice.domain.repository;

import com.cpn.aiithire.lnkinservice.domain.model.entity.Entity;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
