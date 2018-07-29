package com.activeweb.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activeweb.aps.beans.LoanApplicant;
import com.activeweb.aps.processor.ApplicationProcessor;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationProcessor processor;

	@GetMapping("/customer/{applicantId}")
	public LoanApplicant getCustomerData(@PathVariable Integer applicantId) {
		return processor.getCustomer(applicantId);
	}

	@PostMapping("/customer")
	public void createApplicant() {
		processor.insertCustomer(null);
	}

	@DeleteMapping("/customer/{applicantId}")
	public void deleteApplicant(@PathVariable Integer applicantId) {
		LoanApplicant applicant = new LoanApplicant();
		applicant.setApplicantId(applicantId);
		processor.deleteCustomer(applicant);
	}
}
