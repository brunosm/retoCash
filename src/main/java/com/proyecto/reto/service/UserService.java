package com.proyecto.reto.service;



import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.proyecto.reto.model.UserModel;



public interface UserService {
	
	public abstract ResponseEntity<?> getUser(String id);
	
	public abstract ResponseEntity<?> addUser(@Valid UserModel user);
	
	public abstract ResponseEntity<?> deleteUser(String id);
	

}
