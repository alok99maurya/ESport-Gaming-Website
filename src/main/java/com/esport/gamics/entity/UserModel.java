package com.esport.gamics.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String number;
	private String role;
	private String usertype;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="team_id")
	private Teams team;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<MessageModel> message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public List<MessageModel> getMessage() {
		return message;
	}
	public void setMessage(List<MessageModel> message) {
		this.message = message;
	}
	public UserModel(String name, String email, String password, String number, String role, String usertype) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
		this.role = role;
		this.usertype = usertype;
	}
	
	public Teams getTeam() {
		return this.team;
	}
	public void setTeam(Teams team) {
		this.team=team;
	}
}
