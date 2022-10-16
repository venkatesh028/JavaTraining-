package com.ideas2it.dao.daoImpl;

import java.util.Map;
import java.util.HashMap;

/**
 * Perform the creation, Read , update and Delete for the profile 
 * 
 * @version 1.0 15-OCT-2022
 * @author  Venkatesh TM
 */
public class ProfileDaoImpl implements ProfileDao {
    private Map<String, Profile> profiles;
    
    private ProfileDaoImpl() {
        this.profiles = new HashMap<>();
    }
    
    public static synchronized UserDaoImpl getInstance() {
        if (profileDaoImpl == null) {
            profileDaoImpl = new ProfileDaoImpl();        
        }
        return profileDaoImpl; 
    } 
    
    public Profile create(Profile profile) {
        return profiles.put(profile.getProfileId(), profile);
    }
    
    public Profile getProfile(String profileId) {
        return profiles.get(profileId);
    }
    
    public List<Profile> getProfiles() {
        return profiles.values();
    }
     
    public Profile update(Profile profile) {
        return profiles.replace(profile.getProfileId, profile);
    }

    public Profile delete(String profileId) {
        return profiles.remove(profileId);   
    }      
}
