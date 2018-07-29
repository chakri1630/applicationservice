package com.activeweb.aps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activeweb.aps.beans.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer>{

}
