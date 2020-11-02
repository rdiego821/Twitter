package com.twitter.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.apirest.entity.Profile;
import com.twitter.apirest.service.ProfileService;

@RestController
@RequestMapping("/api")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profiles")
	public List<Profile> findAll(){
		//retornará todos los usuarios
		return profileService.findAll();
	}
	
	@GetMapping("/profiles/{profileId}")
	public Profile getProfile(@PathVariable int profileId){
		Profile profile = profileService.findById(profileId);
		
		if(profile == null) {
			throw new RuntimeException("Profile id not found -"+profileId);
		}
		return profile;
	}
	
	@PutMapping("/profiles/{profileId}")
	public Profile updateProfile(@RequestBody Profile profile) {
		profileService.update(profile);
		return profile;
	}
}
