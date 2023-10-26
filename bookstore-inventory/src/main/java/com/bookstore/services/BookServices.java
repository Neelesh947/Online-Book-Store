package com.bookstore.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bookstore.model.Book;

public interface BookServices {

	Page<Book> getList(int pn);

	void addBooks(Book book);

	void removeBook(int bid);

	Book getBook(int bid);

	void getUpdate(Book book);

	List<Book> findBybid(int bid);

	List<Book> findByAuthor(String author);

	List<Book> findBybcategory(int catid);

	List<Book> findByPublisher(int pubid);

	List<Book> findByTitle(String title);

}
