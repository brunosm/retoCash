package com.proyecto.reto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.reto.service.LoanService;

@Controller
public class LoanController {
	
	@Autowired
	@Qualifier("loanServiceImpl")
	private LoanService loanService;
	
	@RequestMapping(path = "/loans", method= RequestMethod.GET)
	public ResponseEntity<?> veroffice(@RequestParam(value="page", required = true)Integer page,
			@RequestParam(value="size", required = true)Integer size,
			@RequestParam(value="user_id", required = false)Integer userId){
	
		if(userId==null) {
			return loanService.findAllLoans(page, size);
		}else {
			return loanService.findAllLoansById(page, size, userId);
		}
		
		
	}

}
