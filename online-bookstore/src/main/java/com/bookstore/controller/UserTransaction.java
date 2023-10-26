package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookstore.services.TransactionService;

@Controller
public class UserTransaction
{
	@Autowired
	private TransactionService tservice;
}
