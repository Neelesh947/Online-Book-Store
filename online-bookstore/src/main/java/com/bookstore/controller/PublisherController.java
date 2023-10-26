package com.bookstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.BookPublisher;
import com.bookstore.services.PublisherServices;

@Controller
@RequestMapping("bookstore/user/publisher")
public class PublisherController
{
	@Autowired
	private PublisherServices pservice;
	
	
	
	@RequestMapping("details")
	public String getPublisherView(int pid, Model model)
	{
		BookPublisher pub=pservice.editCategory(pid);
		model.addAttribute("pub",pub);
		return "publisher/publisher-details";
	}
}
