package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.UserTransaction;

public interface TransactionRepository extends JpaRepository <UserTransaction, Integer>
{

}
