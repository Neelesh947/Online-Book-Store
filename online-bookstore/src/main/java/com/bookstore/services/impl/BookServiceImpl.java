package com.bookstore.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.services.BookServices;

@Service
public class BookServiceImpl implements BookServices
{
	@Autowired
	private BookRepository repo;

	public Page<Book> getList(int pn) 
	{
		Pageable page=PageRequest.of(pn, 1);
		return repo.findAll(page);
	}
	
	public Book getBook(int bid)
	{
		return repo.findById(bid).orElse(null);
	}
	
	public void getUpdate(Book book) 
	{
		repo.save(book);
	}
	
	public List<Book> findBybid(int bid)
	{
		return repo.findBybid(bid);
	}
	
	public List<Book> findByAuthor(String author)
	{
		return repo.findByAuthor(author);
	}
	
	public List<Book> findBybcategory(int catid) 
	{
		return repo.findByCatid(catid);
	}
	
	public List<Book> findByPublisher(int pubid) 
	{
		return repo.findByPubid(pubid);
	}
	
	public List<Book> findByTitle(String title) 
	{
		return repo.findByTitle(title);
	}

	public Book getBooks(int bid) 
	{
		return repo.findById(bid).orElse(null);
	}

	public void updateQuantity(int quantity, int bid) 
	{
		repo.updateBookQuantity(quantity, bid);
	}


}
