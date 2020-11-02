package com.twitter.apirest.entity;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="portfolio")
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_info")
	private String userInfo;
	
	@Column(name="title")
	private String title;
	
	@Column(name="text_description")
	private String textDescription;

	@Column(name="image")
    private Blob image;

	public Profile() {}
	
	public Profile(int id, String userInfo, String title, String textDescription, Blob image) {
		this.id = id;
		this.userInfo = userInfo;
		this.title = title;
		this.textDescription = textDescription;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", userInfo=" + userInfo + ", title=" + title + ", textDescription=" + textDescription
				+ ", image=" + image + "]";
	}
	
}