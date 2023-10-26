package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("bookstore/inventory/book")
public class BookController 
{
	@Autowired
	private  BookServices bservice;
	@Autowired
	private CategoryService cservice;
	@Autowired
	private PublisherServices pservice;
	
	@RequestMapping("list")
	public String getBookView(int pn, Model model)
	{
		Page<Book> plist=bservice.getList(pn-1);
		int tp=plist.getTotalPages();
		model.addAttribute("tp", tp);
		model.addAttribute("pn", pn);
		List<Book> list=plist.toList();
		model.addAttribute("blist",list);
		return "book/book-list";
	}
	
	@RequestMapping("add")
	public String addBook(Model model)
	{
		List<BookCategory> clist=cservice.getList();
		List<BookPublisher> plist=pservice.getList();
		model.addAttribute("clist",clist);
		model.addAttribute("plist",plist);
		return "book/add-book";
	}
	
	@RequestMapping("save")
	public String getSaveBook(Book book)
	{
		bservice.addBooks(book);
		return "redirect:list?pn=1";
	}
	
	@RequestMapping("remove")
	public String getRemoveView(int bid)
	{
		bservice.removeBook(bid);
		return "redirect:list?pn=1";
	}
	
	@RequestMapping("edit")
	public String getEditView(int bid, Model model)
	{
		Book book=bservice.getBook(bid);
		model.addAttribute("book",book);
		return "book/edit-book";
	}
	
	@RequestMapping("editsave")
	public String getUpdateView(Book book)
	{
		bservice.getUpdate(book);
		return "redirect:list";
	}
	

}
