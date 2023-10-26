package com.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.model.Book;


public interface BookRepository extends JpaRepository<Book,Integer> 
{

	List<Book> findBybid(int bid);

	List<Book> findByAuthor(String author);

	List<Book> findByCatid(int catid);

	List<Book> findByPubid(int pubid);

	List<Book> findByTitle(String title);
	
	@Modifying
	@Transactional
	@Query("update Book set copies=copies-:c where bid=:b")
	void updateBookQuantity(@Param("c")int qty, @Param("b") int bookid);
}
