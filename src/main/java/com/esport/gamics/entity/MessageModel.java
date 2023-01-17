package com.esport.gamics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String message;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	private UserModel user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
}
