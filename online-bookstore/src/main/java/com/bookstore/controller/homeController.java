package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/user/home")
public class homeController
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "home/home-page";
	}
}
