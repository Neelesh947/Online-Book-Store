package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.BookCategory;
import com.bookstore.services.CategoryService;

@Controller
@RequestMapping("bookstore/user/category")
public class CategoryController
{
	@Autowired
	private CategoryService cservice;
	
	
	@RequestMapping("details")
	public String getCategoryDetails(int cid, Model model)
	{
		BookCategory cat=cservice.getBookCategory(cid);
		model.addAttribute("cat",cat);
		return "category/category-details";
	}
}
