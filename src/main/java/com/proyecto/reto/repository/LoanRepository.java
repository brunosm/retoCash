package com.proyecto.reto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.reto.entity.Loan;

@Repository("loanRepository")
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	Page<Loan> findAllByUserID(Integer userID,Pageable pageable);

}
