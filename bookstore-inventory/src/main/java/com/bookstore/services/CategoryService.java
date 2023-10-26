package com.bookstore.services;

import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.model.BookCategory;

public interface CategoryService {

	List<BookCategory> getList();

	void saveCategory(BookCategory cat);

	void saveCategory(int cid);

	BookCategory getBookCategory(int cid);

	void getUpdate(BookCategory cat);


}
