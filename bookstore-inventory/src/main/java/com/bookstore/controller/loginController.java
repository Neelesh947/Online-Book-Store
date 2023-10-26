package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory/login")
public class loginController 
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "home/login";
	}
	
	@RequestMapping("authenticate")
	public String getAuthenticateUser(String uid, String pass, Model model)
	{
		if(uid.equals("admin") && pass.equals("admin"))
		{
			return "redirect:/bookstore/inventory/home";
		}
		model.addAttribute("msg","Authenticate Failed");
		return "home/login";
	}
}
