package com.twitter.apirest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twitter.apirest.entity.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO  {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Profile> findAll(){
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Profile> theQuery = currentSession.createQuery("from portfolio", Profile.class);
		
		List<Profile> profiles = theQuery.getResultList();
		
		return profiles;
	}
	
	@Override
	public Profile findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Profile profile = currentSession.get(Profile.class, id);
		
		return profile;
	}
	
	@Override
	public void update(Profile profile) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(profile);	
	}
}
