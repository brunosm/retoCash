package com.proyecto.reto.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.reto.entity.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
