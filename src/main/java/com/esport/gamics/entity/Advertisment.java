package com.esport.gamics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.esport.gamics.helper.AdvertismentHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="adss")
public class Advertisment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String url;
	private String img;
	private AdvertismentHelper status;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public AdvertismentHelper getStatus() {
		return status;
	}
	public void setStatus(AdvertismentHelper status) {
		this.status = status;
	}
	
}
