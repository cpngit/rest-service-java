package com.cpn.aiithire.lnkinservice.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cpn.aiithire.lnkinservice.domain.model.entity.Entity;
import com.cpn.aiithire.lnkinservice.domain.model.entity.LnkProfile;
import org.springframework.stereotype.Repository;

@Repository("LnkProfileRepository")
public class InMemLnkProfileRepository implements LnkProfileRepository<LnkProfile, String> {

    private Map<String, LnkProfile> entities;

    public InMemLnkProfileRepository() {
        entities = new HashMap();
        LnkProfile lnkProfile = new LnkProfile("Cassio Nunes", "https://www.linkedin.com/in/cassionunes/");
        entities.put("1", lnkProfile);
    }

    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public void add(LnkProfile entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(LnkProfile entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    @Override
    public Collection<LnkProfile> getAll() {
        return entities.values();
    }

    @Override
    public Collection<LnkProfile> findByName(String name) throws Exception {
        Collection<LnkProfile> lnkProfiles = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
                lnkProfiles.add(v);
            }
        });
        return lnkProfiles;
    }
}
