package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.Book;


public interface BookRepository extends JpaRepository<Book,Integer> 
{

	List<Book> findBybid(int bid);

	List<Book> findByAuthor(String author);

	List<Book> findByCatid(int catid);

	List<Book> findByPubid(int pubid);

	List<Book> findByTitle(String title);

	
}
