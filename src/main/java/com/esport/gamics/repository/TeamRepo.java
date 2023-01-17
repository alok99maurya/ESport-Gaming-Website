package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esport.gamics.entity.Teams;

public interface TeamRepo extends JpaRepository<Teams, Integer>{

}
