package com.bookstore.services;

import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.model.BookCategory;

public interface CategoryService {

	List<BookCategory> getList();

	BookCategory getBookCategory(int cid);

	
}
