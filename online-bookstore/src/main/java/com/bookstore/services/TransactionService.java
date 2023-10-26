package com.bookstore.services;

import com.bookstore.model.UserTransaction;

public interface TransactionService 
{

	void saveTransaction(UserTransaction tr);
	
}
