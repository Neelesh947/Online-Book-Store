package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher,Integer> {

}
