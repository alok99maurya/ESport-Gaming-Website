package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findByEmail(String email);

}
