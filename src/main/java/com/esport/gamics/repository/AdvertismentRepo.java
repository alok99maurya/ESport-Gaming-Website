package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.Advertisment;
@Repository
public interface AdvertismentRepo extends JpaRepository<Advertisment, Integer>{

}
