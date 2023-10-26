package com.bookstore.services;

import com.bookstore.model.User;

public interface UserService {

	void createAccount(User user);

	boolean isUserExist(String uid);

	User getUser(String uid);

}
