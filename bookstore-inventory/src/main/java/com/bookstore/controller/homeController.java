package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookstore/inventory")
public class homeController
{
	@RequestMapping("home")
	public String getLoginView()
	{
		return "home/home-page";
	}
}
