package com.ideas2it.dao;

import java.util.HashMap;
import java.util.Map;

import com.ideas2it.model.Profile;

public class ProfileDao {
    private static Map<Integer, Profile> userProfiles;
    private Profile profile;

    static {
        userProfiles = new HashMap<>();
    }
    
    /** 
     * Create a profile with the user details 
     *
     * @param  userId   userId of the user
     * @param  userName userName of the user 
     * @param  name     name of the user
     * @return boolean  true after setuping the profile 
     */
    public boolean setProfile(int userId, String userName, String name) {
        profile = new Profile(userName, name);
        userProfiles.put(userId, profile);
        return true;   
    }
    
    /**
     * update the name of the user
     * 
     * @param  userId  userid of the user
     * @param  newName new name given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateName(int userId, String newName) {
        profile = userProfiles.get(userId);
        profile.setName(newName);
        return true;
    }

    /**
     * update the username of the user
     * 
     * @param  userId  userid of the user
     * @param  newUserName new username given by the user
     * @return boolean true after updateing the username
     */  
    public boolean updateUserName(int userId, String newUserName) {
        profile = userProfiles.get(userId);
        profile.setUserName(newUserName);
        return true;
    }

    /**
     * update the bio of the user
     * 
     * @param  userId  userid of the user
     * @param  bio     bio given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateBio(int userId, String bio) {
        profile = userProfiles.get(userId);
        profile.setBio(bio);
        return true;
    }
    
    /**
     * shows the profile to the user
     *
     * @param  userID  userid of the user
     * @return profile profile of the user
     */
    public Profile showProfile(int userId) {
        return userProfiles.get(userId);
    }
    
    public Map<Integer, Profile> getUserProfiles() {
        return userProfiles;
    }
    
}