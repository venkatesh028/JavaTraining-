package com.ideas2it.dao;

import com.ideas2it.model.Profile;

public class ProfileDao {  

    public Profile Create(Profile profile);

    public Profile getProfile(String profileId); 
    
    public Profile update(Profile profile);
    
    public Profile delete(String profileId);
   
}
