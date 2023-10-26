package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory, Integer>
{

}
