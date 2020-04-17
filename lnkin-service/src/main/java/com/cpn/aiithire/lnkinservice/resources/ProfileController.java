package com.cpn.aiithire.lnkinservice.resources;

import com.cpn.aiithire.lnkinservice.domain.model.entity.Entity;
import com.cpn.aiithire.lnkinservice.domain.model.entity.LnkProfile;
import com.cpn.aiithire.lnkinservice.domain.service.LnkProfileService;
import com.cpn.aiithire.lnkinservice.domain.valueobject.LnkProfileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/profiles")
public class ProfileController {

    protected static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    protected LnkProfileService profileService;

    @Autowired
    public ProfileController(LnkProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<LnkProfile>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("profile-service findByName() invoked:{} for {} ", profileService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<LnkProfile> profiles;
        try {
            profiles = profileService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return profiles.size() > 0 ? new ResponseEntity<>(profiles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{profile_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("profile_id") String id) {
        logger.info(String.format("profile-service findById() invoked:{} for {} ", profileService.getClass().getName(), id));
        id = id.trim();
        Entity profile;
        try {
            profile = profileService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return profile != null ? new ResponseEntity<>(profile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LnkProfile> add(@RequestBody LnkProfileVO lnkProfileVO) {
        logger.info(String.format("profile-service add() invoked: %s for %s", profileService.getClass().getName(), lnkProfileVO.getName()));
        System.out.println(lnkProfileVO);
        LnkProfile profile = new LnkProfile(null,null);
        BeanUtils.copyProperties(lnkProfileVO, profile);
        try {
            profileService.add(profile);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Profile REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
