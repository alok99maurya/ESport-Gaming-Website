package com.esport.gamics.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDateTime date;
	private int teamsize;
	private int totalteams;
	private String url;
	private int fees;
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<RegisteredEvents> list;
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	public int getTotalteams() {
		return totalteams;
	}
	public void setTotalteams(int totalteams) {
		this.totalteams = totalteams;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<RegisteredEvents> getList() {
		return list;
	}
	public void setList(List<RegisteredEvents> list) {
		this.list = list;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	
}
