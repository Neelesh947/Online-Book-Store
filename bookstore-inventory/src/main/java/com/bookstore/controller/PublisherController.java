package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.BookPublisher;
import com.bookstore.services.PublisherServices;

@Controller
@RequestMapping("bookstore/inventory/publisher")
public class PublisherController
{
	@Autowired
	private PublisherServices pservice;
	
	@RequestMapping("list")
	public String getPublisherList(Model model)
	{
		List<BookPublisher> list=pservice.getList();
		model.addAttribute("plist",list);
		return "publisher/publisher-list";
	}
	
	@RequestMapping("add")
	public String addPublisherView()
	{
		return "publisher/add-publisher";
	}
	
	@RequestMapping("save")
	public String SavePublisherView(BookPublisher pub)
	{
		pservice.savePublisher(pub);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String getEditView(int pid, Model model)
	{
		BookPublisher pub=pservice.editCategory(pid);
		model.addAttribute("pub",pub);
		return "publisher/edit-publisher";
	}
	
	@RequestMapping("update")
	public String getUpdatePublisherRecord(BookPublisher pub)
	{
		pservice.updateCategory(pub);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String getRemovePublisher(int pid)
	{
		pservice.removeCategory(pid);
		return "redirect:list";
	}
	
	@RequestMapping("details")
	public String getPublisherView(int pid, Model model)
	{
		BookPublisher pub=pservice.editCategory(pid);
		model.addAttribute("pub",pub);
		return "publisher/publisher-details";
	}
}
