package com.bookstore.controller;

import java.time.LocalDate;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.Book;
import com.bookstore.model.UserTransaction;
import com.bookstore.services.BookServices;
import com.bookstore.services.TransactionService;

@Controller
@RequestMapping("bookstore/user/purchase")
public class PurchaseController 
{
	@Autowired private BookServices bservice;
	@Autowired private TransactionService tservice;
	private Book book;
	
	@RequestMapping("")
	public String getPurchaseView(Model model,int bid)
	{
		Book book=bservice.getBook(bid);
		model.addAttribute("book",book);
		return "purchase/purchase-now";
	}
	@RequestMapping("do")
	public String doPurchase(Model model,int quantity, HttpSession ses)
	{
		UserTransaction tr=new UserTransaction();
		tr.setUserid((String)ses.getAttribute("userid"));
		tr.setBid(book.getBid());
		tr.setQuantity(quantity);
		tr.setPrice(book.getPrice());
		tr.setDate(LocalDate.now().toString());
		tservice.saveTransaction(tr);
		bservice.updateQuantity(quantity, book.getBid());
		return "purchase/buy";
	}
	
}
