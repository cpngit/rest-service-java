package com.cpn.aiithire.lnkinservice.domain.service;

import com.cpn.aiithire.lnkinservice.domain.model.entity.Entity;
import com.cpn.aiithire.lnkinservice.domain.model.entity.LnkProfile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface LnkProfileService {

    public void add(LnkProfile restaurant) throws Exception;

    public void update(LnkProfile restaurant) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String restaurantId) throws Exception;

    public Collection<LnkProfile> findByName(String name) throws Exception;

    public Collection<LnkProfile> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
