package com.esport.gamics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.esport.gamics.entity.UserModel;
import com.esport.gamics.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository urepo;
	@Autowired
	BCryptPasswordEncoder encode;
	public UserModel addUser(UserModel user) {
		if(findByEmail(user.getEmail())!=null) return null;
		user.setPassword(encode.encode(user.getPassword()));
		return urepo.save(user);
	}
	public UserModel findByEmail(String email) {
		UserModel user=urepo.findByEmail(email);
		return user;
	}
	public List<UserModel> getAllUser(){
		return urepo.findAll();
	}
}