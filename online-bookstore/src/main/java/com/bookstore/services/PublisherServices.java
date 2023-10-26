package com.bookstore.services;

import java.util.List;

import com.bookstore.model.BookPublisher;

public interface PublisherServices {

	List<BookPublisher> getList();
	BookPublisher editCategory(int pid);

}
