package com.ideas2it.controller;

import com.ideas2it.service.ProfileService;
import com.ideas2it.model.Profile;

/**
 * Perform the set, get and update operation for the profile
 *
 * @version 1.0 15-SEP-2022
 * @author  Venkatesh TM
 */
public class ProfileController {
    
    ProfileService profileService;

    public ProfileController() {
        this.profileService = new ProfileService();
    }
    
    /**
     * Setup the profile of the user  
     *  
     * @param  userId   userId of the user
     * @parma  userName userName of the user
     * @parma  name     name of the user
     * @return boolean  true after setup the profile
     */
    public boolean setProfile(int userId, String userName, String name) {
        return profileService.setProfile(userId, userName, name);
        
    }
    
    /**
     * Shows the profile of the user
     * 
     * @param  userId  userId of the user
     * @return Profile profile of the user
     */
    public Profile showProfile(int userId) {
        return profileService.showProfile(userId);
    }
    
    /**
     * Gives the userName of the user based on userId
     * 
     * @param  userId   userId of the user
     * @return userName userName of the user
     */
    public String getUserName(int userId) {
        return profileService.getUserName(userId);
    }
    
    /**
     * Update the bio of the user
     * 
     * @param  userId  userId of the user
     * @param  bio     bio of the user
     * @return boolean true based on successfully updated
     */
    public boolean updateBio(int userId, String bio) {
        return profileService.updateBio(userId, bio);
    }
    
    /**
     * Update the userName of the user
     *  
     * @param  userId      userid of the user
     * @param  newUserName updated username of the user
     * @return boolean     true based on successfully updated
     */ 
    public boolean updateUserName(int userId, String newUserName) {
        return profileService.updateUserName(userId, newUserName);
    }
    
    /**
     * Update the name of the user
     * 
     * @param  userId  userId of the user 
     * @param  newName update name of the user
     * @return boolean true based on successfully updated
     */ 
    public boolean updateName(int userId, String newName) {
        return profileService.updateName(userId, newName);
    }
    
}
