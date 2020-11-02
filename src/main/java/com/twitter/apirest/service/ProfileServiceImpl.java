package com.twitter.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twitter.apirest.dao.ProfileDAO;
import com.twitter.apirest.entity.Profile;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

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
		
		Twitter twitter = new TwitterFactory().getInstance();
		try {
			User user = twitter.verifyCredentials();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile;
	}
	
	@Override
	public void update(Profile profile) {
		profileDAO.update(profile);

	}

}
