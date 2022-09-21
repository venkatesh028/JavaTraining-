package com.ideas2it.dao.daoImpl;

import java.util.HashMap;
import java.util.Map;

import com.ideas2it.dao.ProfileDao;
import com.ideas2it.model.Profile;

/**
 * Perform the Set, update, view function for the profile
 *
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public class ProfileDaoImpl implements ProfileDao {
    private static Map<String, Profile> userProfiles;
    private Profile profile;

    static {
        userProfiles = new HashMap<>();
    }
    
    @Override
    public boolean setProfile(String userId, String userName, String name) {
        profile = new Profile(userName, name);
        userProfiles.put(userId, profile);
        return true;   
    }
    
    @Override
    public boolean updateName(String userId, String newName) {
        profile = userProfiles.get(userId);
        profile.setName(newName);
        return true;
    }

    @Override
    public boolean updateUserName(String userId, String newUserName) {
        profile = userProfiles.get(userId);
        profile.setUserName(newUserName);
        return true;
    }
    
    @Override
    public boolean updateBio(String userId, String bio) {
        profile = userProfiles.get(userId);
        profile.setBio(bio);
        return true;
    }
    
    @Override 
    public Profile showProfile(String userId) {
        return userProfiles.get(userId);
    }
    
    @Override 
    public Map<String, Profile> getUserProfiles() {
        return userProfiles;
    }
    
}