package com.esport.gamics.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="register")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisteredEvents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String members;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="events_id")
	private Events event;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="team_id")
	private Teams team;
	
	
	
}
