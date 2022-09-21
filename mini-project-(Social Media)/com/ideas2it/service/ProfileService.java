package com.ideas2it.service;

import java.util.HashMap;
import java.util.Map;

import com.ideas2it.model.Profile;
import com.ideas2it.dao.ProfileDao;
import com.ideas2it.dao.daoImpl.ProfileDaoImpl;

/** 
 * Perform the Create, update, delete taks for the user profile
 * 
 * @version 1.0 17-SEP-2022
 * @author  Venkatesh TM
 */
public class ProfileService {
    private static Map<String,Profile> userProfiles;
    private Profile profile;
    private ProfileDao profileDao;

    static {
        userProfiles = new HashMap<>();
    }
    
    public ProfileService() {
        this.profileDao = new ProfileDaoImpl();
    }
    
    /** 
     * Create a profile with the user details 
     *
     * @param  userId   userId of the user
     * @param  userName userName of the user 
     * @param  name     name of the user
     * @return boolean  true after setuping the profile 
     */
    public boolean setProfile(String userId, String userName, String name) {
        return profileDao.setProfile(userId, userName, name);
    }
    
    /**
     * shows the profile to the user
     *
     * @param  userID  userid of the user
     * @return profile profile of the user
     */
    public Profile showProfile(String userId) {
        return profileDao.showProfile(userId);
    }
   
    /**
     * Gets the userName of the user based on the userId
     *
     * @param  userId   userid of the user
     * @return userName userName of the user
     */
    public String getUserName(String userId) {
        userProfiles = profileDao.getUserProfiles();
        profile = userProfiles.get(userId);
        return profile.getUserName();
    }

    /**
     * update the name of the user
     * 
     * @param  userId  userid of the user
     * @param  newName new name given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateName(String userId, String newName) {
        return profileDao.updateName(userId, newName);
    }    

    /**
     * update the username of the user
     * 
     * @param  userId  userid of the user
     * @param  newUserName new username given by the user
     * @return boolean true after updateing the username
     */    
    public boolean updateUserName(String userId, String newUserName) {
        return profileDao.updateUserName(userId, newUserName);
    }

    /**
     * update the bio of the user
     * 
     * @param  userId  userid of the user
     * @param  bio     bio given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateBio(String userId, String bio) {
        return profileDao.updateBio(userId, bio);
    }
      
}
