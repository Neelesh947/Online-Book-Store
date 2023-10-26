package com.bookstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.BookPublisher;
import com.bookstore.repository.PublisherRepository;
import com.bookstore.services.PublisherServices;

@Service
public class PublisherServiceImpl implements PublisherServices
{
	@Autowired	
	private PublisherRepository repo;

	public List<BookPublisher> getList()
	{
		return repo.findAll();
	}

	public void savePublisher(BookPublisher pub) 
	{
		repo.save(pub);
	}

	public BookPublisher editCategory(int pid) 
	{
		return repo.findById(pid).orElse(null);
	}

	public void updateCategory(BookPublisher pub)
	{
		repo.save(pub);
	}

	public void removeCategory(int pid)
	{
		repo.deleteById(pid);
	}

	


}
