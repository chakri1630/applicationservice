package com.activeweb.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.activeweb.aps.beans.LoanApplicant;

public interface CustomerDAO extends JpaRepository<LoanApplicant, Integer>  {
	
	@Query("SELECT c FROM Applicant c WHERE LOWER(c.firstName) = LOWER(:firstName)")
	LoanApplicant getLoanByName(@Param("name") String firstName);
	
}
