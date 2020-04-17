package com.cpn.aiithire.lnkinservice.domain.service;

import com.cpn.aiithire.lnkinservice.domain.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
