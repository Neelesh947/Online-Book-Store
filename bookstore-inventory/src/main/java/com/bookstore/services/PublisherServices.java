package com.bookstore.services;

import java.util.List;

import com.bookstore.model.BookPublisher;

public interface PublisherServices {

	List<BookPublisher> getList();

	void savePublisher(BookPublisher pub);

	BookPublisher editCategory(int pid);

	void updateCategory(BookPublisher pub);

	void removeCategory(int pid);

	

}
