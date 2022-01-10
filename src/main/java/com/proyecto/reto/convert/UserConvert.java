package com.proyecto.reto.convert;

import org.springframework.stereotype.Component;

import com.proyecto.reto.entity.User;
import com.proyecto.reto.model.UserModel;


@Component("userConvert")
public class UserConvert {
	
	public User convertModeltoEntity (UserModel model) {
		User entity = new User();
		
		entity.setEmail(model.getEmail());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		
		return entity; 
	}

}
