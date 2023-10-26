package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.BookCategory;
import com.bookstore.services.CategoryService;

@Controller
@RequestMapping("bookstore/inventory/category")
public class CategoryController
{
	@Autowired
	private CategoryService cservice;
	
	@RequestMapping("list")
	public String getCategoryList(Model model)
	{
		List<BookCategory> list=cservice.getList();
		model.addAttribute("clist",list);
		return "category/category-list";
	}
	
	@RequestMapping("add")
	public String getAddCategoryView()
	{
		return "category/add-category";
	}
	
	@RequestMapping("save")
	public String getySaveCategory(BookCategory cat)
	{
		cservice.saveCategory(cat);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String getRemoveCategory(int cid)
	{
		cservice.saveCategory(cid);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String getEditView(int cid, Model model)
	{
		BookCategory cat=cservice.getBookCategory(cid);
		model.addAttribute("cat",cat);
		return "category/edit-category";
	}
	
	@RequestMapping("update")
	public String getUpdateView(BookCategory cat)
	{
		cservice.getUpdate(cat);
		return "redirect:list";
	}
	
	@RequestMapping("details")
	public String getCategoryDetails(int cid, Model model)
	{
		BookCategory cat=cservice.getBookCategory(cid);
		model.addAttribute("cat",cat);
		return "category/category-details";
	}
}
