package com.proyecto.reto.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.reto.model.UserModel;
import com.proyecto.reto.service.UserService;


@Controller
public class UserController {
	
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@RequestMapping(path = "/users/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable(value="id", required = true)String id){
		
		return userService.getUser(id);
		
	}
	
	@RequestMapping(path = "/users/add", method= RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody @Valid UserModel user){

		return userService.addUser(user);
		
	}
	
	@RequestMapping(path = "/users/delete/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value="id", required = true)String id){

		return userService.deleteUser(id);
		
	}

}
