package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.Events;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer>{

}
