package com.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.User;
import com.bookstore.services.UserService;

@Controller
@RequestMapping("bookstore/user")
public class UserController
{
	@Autowired private UserService service;
	
	@RequestMapping("login")
	public String UserLoginView()
	{
		return "user/login";
	}
	
	@RequestMapping("create-account")
	public String getRegistrationView(Model model)
	{
		model.addAttribute("user",new User());
		return "user/registration";
	}
	
	@RequestMapping("registerme")
	public String getConfirmRegistrationView(User user,Model model)
	{
		String uid=user.getUserid();
		boolean u=service.isUserExist(uid);
		if(u)
		{
			model.addAttribute("msg","Already exist");
			return "user/registration";
		}
		service.createAccount(user);
		model.addAttribute("name", user.getName());
		return "user/register-success";
	}
	
	@RequestMapping("authentication")
	public String getSucessLogin(String uid,String pass,Model model,HttpSession ses)
	{
		User user=service.getUser(uid);
		if(user!=null)
		{
			String dpass=user.getPassword();
			if(pass.equals(dpass))
			{
				ses.setAttribute("name",user.getName());
				return "redirect:home";
			}
			else
			{
				model.addAttribute("msg","Entered password is wrong");
			}
		}
		else
			model.addAttribute("msg", "Entered User id not exists");
		model.addAttribute("userid",uid);
		
		return "user/login";
	}
	
	@RequestMapping("logout")
	public String getLogout(HttpSession ses,Model model)
	{
		model.addAttribute("name", ses.getAttribute("name"));
		ses.invalidate();
		return "user/logout-success";
	}
}
