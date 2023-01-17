package com.esport.gamics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.esport.gamics.entity.UserModel;
import com.esport.gamics.service.UserService;
@Component
public class DbUpdate implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	private UserService userv;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		initDb();
		
	}
	public void initDb() {
		if(userv.getAllUser().size()==0) {
			try {
			userv.addUser(new UserModel("Mr. Vaibhav",
					"misravaibhav752@gmail.com","Tannu@123","1234567890","ROLE_ADMIN","ADMIN"));
			userv.addUser(new UserModel("Mr. Alok",
					"alok99maurya@gmail.com","Alok@123","1234567890","ROLE_ADMIN","ADMIN"));
			}
			catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

}
