package com.bookstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.BookCategory;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryRepository repo;

	public List<BookCategory> getList() 
	{
		return repo.findAll();
	}

	
	public BookCategory getBookCategory(int cid)
	{
		return repo.findById(cid).orElse(null);
	}

}
