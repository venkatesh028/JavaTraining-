package com.ideas2it.dao;

import java.util.Map;

import com.ideas2it.model.Profile;

/**
 * Perform the Set, update, view function for the profile
 *
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public interface ProfileDao {

    /** 
     * Create a profile with the user details 
     *
     * @param  userId   userId of the user
     * @param  userName userName of the user 
     * @param  name     name of the user
     * @return boolean  true after setuping the profile 
     */
    public boolean setProfile(String userId, String userName, String name);
   
    /**
     * update the name of the user
     * 
     * @param  userId  userid of the user
     * @param  newName new name given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateName(String userId, String newName);
    
    /**
     * update the username of the user
     * 
     * @param  userId  userid of the user
     * @param  newUserName new username given by the user
     * @return boolean true after updateing the username
     */
    public boolean updateUserName(String userId, String newUserName);

    /**
     * update the bio of the user
     * 
     * @param  userId  userid of the user
     * @param  bio     bio given by the user
     * @return boolean true after updateing the name
     */
    public boolean updateBio(String userId, String bio);

    /**
     * shows the profile to the user
     *
     * @param  userID  userid of the user
     * @return profile profile of the user
     */
    public Profile showProfile(String userId);
    
    /** 
     * Gets the UserProfile
     *
     * @return userProfile based on userid
     */
    public Map<String, Profile> getUserProfiles();
}