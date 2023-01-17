package com.esport.gamics.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teams {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UserModel> list;
	@OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<RegisteredEvents> events;
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
	public List<UserModel> getList() {
		return list;
	}
	public void setList(List<UserModel> list) {
		this.list = list;
	}
	public List<RegisteredEvents> getEvents() {
		return events;
	}
	public void setEvents(List<RegisteredEvents> events) {
		this.events = events;
	}
	
	
}
