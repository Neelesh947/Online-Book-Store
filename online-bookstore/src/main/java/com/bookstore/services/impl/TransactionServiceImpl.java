package com.bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.UserTransaction;
import com.bookstore.repository.TransactionRepository;
import com.bookstore.services.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	private TransactionRepository repo;

	public void saveTransaction(UserTransaction tr) 
	{
		repo.save(tr);
	}

	
}
