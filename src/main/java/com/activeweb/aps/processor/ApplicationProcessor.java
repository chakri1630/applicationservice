package com.activeweb.aps.processor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.activeweb.aps.beans.Loan;
import com.activeweb.aps.beans.LoanApplicant;
import com.activeweb.aps.beans.Payment;
import com.activeweb.aps.constants.LoanType;
import com.activeweb.aps.dao.CustomerDAO;
import com.activeweb.aps.dao.PaymentDAO;

@EnableJms
@Service
public class ApplicationProcessor {

	Logger logger = LoggerFactory.getLogger(ApplicationProcessor.class);

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	PaymentDAO paymentDAO;

	@JmsListener(destination = "${application-request-queue}")
	public void consume(Object object) {
		logger.info("Consumed object is..." + object);
	}

	public void insertCustomer(LoanApplicant input) {

		LoanApplicant applicant = new LoanApplicant();

		applicant.setFirstName("Chakri");
		applicant.setLastName("K");

		Payment payment = new Payment();
		payment.setPaymentType("Credit Card");
		payment.setApplicant(applicant);

		List<Payment> payments = new ArrayList<>();
		payments.add(payment);

		applicant.setPayment(payments);

		customerDAO.save(applicant);

		// paymentDAO.save(payment);

	}

	public LoanApplicant getCustomer(Integer applicantId) {
		Optional<LoanApplicant> applicant = customerDAO.findById(applicantId);
		return applicant.get();
	}

	public void deleteCustomer(LoanApplicant applicant) {
		customerDAO.delete(applicant);
	}

	public Integer createLoan(BigDecimal amount, String loanName, Integer applicantId) {

		Loan loan = new Loan();
		loan.setAmount(new BigDecimal(20000));

		System.out.println("Test.." + LoanType.getLoanType(1));

		loan.setLoanType(LoanType.PERSONALLOAN);

		return 1;

	}
	
	public LoanApplicant getCustomer(String name) {
		return customerDAO.getLoanByName(name);
	}

	/*
	 * public String decision(Integer applicantId) { if
	 * (customerDAO.findByLoanApplicantById(applicantId).size() > 11) { return
	 * "Completed"; } return "Pending"; }
	 */

}
