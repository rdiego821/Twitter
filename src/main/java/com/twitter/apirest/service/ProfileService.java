package com.twitter.apirest.service;

import java.util.List;
import com.twitter.apirest.entity.Profile;

public interface ProfileService {
	public List<Profile> findAll();
	
	public Profile findById(int id);
	
	public void update(Profile profile);
}
