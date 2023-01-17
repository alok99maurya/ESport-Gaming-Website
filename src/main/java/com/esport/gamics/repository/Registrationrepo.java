package com.esport.gamics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.Events;
import com.esport.gamics.entity.RegisteredEvents;
@Repository
public interface Registrationrepo extends JpaRepository<RegisteredEvents, Integer>{

}
