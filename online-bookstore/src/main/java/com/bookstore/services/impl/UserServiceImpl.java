package com.bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;
import com.bookstore.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
		@Autowired private UserRepository repo;

		public void createAccount(User user)
		{
			repo.save(user);
		}

		public boolean isUserExist(String uid) 
		{
			return repo.existsById(uid);
		}

		public User getUser(String uid)
		{
			return repo.findById(uid).orElse(null);
		}
}
