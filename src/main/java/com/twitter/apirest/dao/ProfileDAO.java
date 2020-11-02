package com.twitter.apirest.dao;

import java.util.List;
import com.twitter.apirest.entity.Profile;

public interface ProfileDAO {
	public List<Profile> findAll();
	
	public Profile findById(int id);
	
	public void update(Profile profile);
}
