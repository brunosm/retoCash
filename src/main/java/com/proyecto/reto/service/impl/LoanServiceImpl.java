package com.proyecto.reto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.reto.entity.Loan;
import com.proyecto.reto.repository.LoanRepository;
import com.proyecto.reto.service.LoanService;

@Service("loanServiceImpl")
public class LoanServiceImpl implements LoanService {

	@Autowired
	@Qualifier("loanRepository")
	LoanRepository loanRepository;
	
	
	@Override
	public ResponseEntity<?> findAllLoans(Integer page, Integer size) {
		if(page != null && size != null) {
			Pageable pagination = PageRequest.of(page -1 , size);
			try {
				Page<Loan> loans = loanRepository.findAll(pagination);
				if(loans.getTotalElements() > 0) {
					List<Loan> listLoan = loans.getContent();
					return ResponseEntity.status(HttpStatus.OK).body(listLoan);
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay Prestamos");
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falla al realizar la consulta");
			}
		
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faltan parametros");
		}
	}

	@Override
	public ResponseEntity<?> findAllLoansById(Integer page, Integer size, Integer userId) {
		if(page != null && size !=null) {
			
			Pageable pagination = PageRequest.of(page -1 , size);
			try {
				Page<Loan> loans = loanRepository.findAllByUserID(userId, pagination);
				if(loans.getTotalElements() > 0) {
					List<Loan> listLoan = loans.getContent();
					return ResponseEntity.status(HttpStatus.OK).body(listLoan);
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario no tiene Prestamos o no Existe");
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falla al realizar la consulta");
			}
			
			
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faltan Parametros");
		}
	
	}
	
	
	
	
}