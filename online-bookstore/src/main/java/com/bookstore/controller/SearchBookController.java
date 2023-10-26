package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.Book;
import com.bookstore.model.BookCategory;
import com.bookstore.model.BookPublisher;
import com.bookstore.services.BookServices;
import com.bookstore.services.CategoryService;
import com.bookstore.services.PublisherServices;

@Controller
@RequestMapping("bookstore/user/searchbook")
public class SearchBookController 
{
	@Autowired
	private BookServices bservice;
	@Autowired
	private CategoryService cservice;
	@Autowired
	private PublisherServices pservice;
	
	@RequestMapping("")
	public String getSearchView(Model model)
	{
		List<BookCategory> clist=cservice.getList();
		List<BookPublisher> plist=pservice.getList();
		model.addAttribute("clist",clist);
		model.addAttribute("plist",plist);
		return "search/search-books";
	}
	
	@RequestMapping("byid")
	public String searchBookById(int bid,Model model)
	{
		List<Book> list=bservice.findBybid(bid);
		model.addAttribute("list",list);
		model.addAttribute("by", "Byid");
		return "search/search-book-list";
	}
	
	@RequestMapping("byauthor")
	public String searchBookByAuthor(String author,Model model)
	{
		List<Book> list=bservice.findByAuthor(author);
		model.addAttribute("list",list);
		model.addAttribute("by", "By Author");
		return "search/search-book-list";
	}
	
	@RequestMapping("bycategory")
	public String searchBookByCategory(int catid,Model model)
	{
		List<Book> list=bservice.findBybcategory(catid);
		model.addAttribute("list",list);
		model.addAttribute("by", "By Category");
		return "search/search-book-list";
	}
	
	@RequestMapping("bypublisher")
	public String searchBookByPublisher(int pubid,Model model)
	{
		List<Book> list=bservice.findByPublisher(pubid);
		model.addAttribute("list",list);
		model.addAttribute("by", "By Publisher");
		return "search/search-book-list";
	}
	
	@RequestMapping("bytitle")
	public String searchBookByTitle(String title,Model model)
	{
		List<Book> list=bservice.findByTitle(title);
		model.addAttribute("list",list);
		model.addAttribute("by", "By Title");
		return "search/search-book-list";
	}
}
