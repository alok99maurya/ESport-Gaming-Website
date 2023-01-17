package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.Brands;
@Repository
public interface BrandRepo extends JpaRepository<Brands, Integer>{

}
