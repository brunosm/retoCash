package com.proyecto.reto.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.reto.convert.UserConvert;
import com.proyecto.reto.entity.User;
import com.proyecto.reto.model.UserModel;
import com.proyecto.reto.repository.UserRepository;
import com.proyecto.reto.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	UserRepository userRepository;
	
	@Autowired
	@Qualifier("userConvert")
	UserConvert userConvert;
	
	@Override
	public ResponseEntity<?> getUser(String id) {
		if(id == null || " ".equalsIgnoreCase(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error el valor ingresado es vacio");
		}else if(esNumero(id)){
			try {
				Integer idUser = Integer.parseInt(id);
				User user = userRepository.findById(idUser).orElse(null);
				
				if(user== null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
				}else {
					return ResponseEntity.status(HttpStatus.OK).body(user);
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al buscar Usuario");
			}
			
			
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Solo se permite valores numericos");
		}
	}
	
	private boolean esNumero(String cadena) {
		return cadena.matches("[+-]?\\d*(\\.\\d+)?");
	}

	@Override
	public ResponseEntity<?> addUser(@Valid UserModel userModel) {
		
		User user = null;
		
		try { 
			user = userRepository.saveAndFlush(userConvert.convertModeltoEntity(userModel));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear Usuario");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@Override
	public ResponseEntity<?> deleteUser(String id) {
		if(id == null || " ".equalsIgnoreCase(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error el valor ingresado es vacio");
		}else if(esNumero(id)){
			try {
				Integer idUser = Integer.parseInt(id);
				User user = userRepository.findById(idUser).orElse(null);
				
				if(user== null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el usuario a borrar no existe");
				}else {
					userRepository.delete(user);
					return ResponseEntity.status(HttpStatus.OK).body("Usuario Borrador");
					
					
					
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al buscar Usuario");
			}
			
			
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Solo se permite valores numericos");
		}
	}

	

}
