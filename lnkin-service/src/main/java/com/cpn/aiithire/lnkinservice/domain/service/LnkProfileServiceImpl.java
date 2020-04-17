package com.cpn.aiithire.lnkinservice.domain.service;

import com.cpn.aiithire.lnkinservice.domain.model.entity.Entity;
import com.cpn.aiithire.lnkinservice.domain.model.entity.LnkProfile;
import com.cpn.aiithire.lnkinservice.domain.repository.LnkProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service("lnkProfileService")
public class LnkProfileServiceImpl extends BaseService<LnkProfile, String>
        implements LnkProfileService {

    private LnkProfileRepository<LnkProfile, String> lnkProfileRepository;

    @Autowired
    public LnkProfileServiceImpl(LnkProfileRepository<LnkProfile, String> lnkProfileRepository) {
        super(lnkProfileRepository);
        this.lnkProfileRepository = lnkProfileRepository;
    }

    @Override
    public void add(LnkProfile lnkProfile) throws Exception {
        if (lnkProfileRepository.containsName(lnkProfile.getName())) {
            throw new Exception(String.format("There is already a profile with the name - %s", lnkProfile.getName()));
        }

        if (lnkProfile.getName() == null || "".equals(lnkProfile.getName())) {
            throw new Exception("Profile name cannot be null or empty string.");
        }
        super.add(lnkProfile);
    }

    @Override
    public Collection<LnkProfile> findByName(String name) throws Exception {
        return lnkProfileRepository.findByName(name);
    }

    @Override
    public void update(LnkProfile lnkProfile) throws Exception {
        lnkProfileRepository.update(lnkProfile);
    }

    @Override
    public void delete(String id) throws Exception {
        lnkProfileRepository.remove(id);
    }

    @Override
    public Entity findById(String lnkProfileId) throws Exception {
        return lnkProfileRepository.get(lnkProfileId);
    }

    @Override
    public Collection<LnkProfile> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
