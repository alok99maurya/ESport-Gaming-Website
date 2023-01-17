package com.esport.gamics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.esport.gamics.entity.UserModel;
import com.esport.gamics.repository.UserRepository;
@Component
public class CustomUserService implements UserDetailsService{
	@Autowired
	UserRepository urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserModel u=urepo.findByEmail(username);
			if(u==null) {
				throw new UsernameNotFoundException("user name cannot be found");
			}else {
				return new CustomUser(u);
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}

}
