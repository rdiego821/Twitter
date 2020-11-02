package com.twitter.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twitter.apirest.dao.ProfileDAO;
import com.twitter.apirest.entity.Profile;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileDAO profileDAO;
	
	@Override
	public List<Profile> findAll() {
		List<Profile> listProfiles= profileDAO.findAll();
		return listProfiles;
	}
	
	@Override
	public Profile findById(int id) {
		Profile profile = profileDAO.findById(id);
		return profile;
	}
	
	@Override
	public void update(Profile profile) {
		profileDAO.update(profile);

	}

}
