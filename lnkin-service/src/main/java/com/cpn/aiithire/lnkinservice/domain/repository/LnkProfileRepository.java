package com.cpn.aiithire.lnkinservice.domain.repository;

import java.util.Collection;

public interface LnkProfileRepository<LnkProfile, BigInteger> extends Repository<LnkProfile, BigInteger> {

    boolean containsName(String name);

    public Collection<LnkProfile> findByName(String name) throws Exception;
}
