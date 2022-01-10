package com.proyecto.reto.service;

import org.springframework.http.ResponseEntity;

public interface LoanService {
	
	ResponseEntity<?> findAllLoans(Integer page, Integer size);
	
	ResponseEntity<?> findAllLoansById(Integer page, Integer size,Integer userId);
	
	

}
