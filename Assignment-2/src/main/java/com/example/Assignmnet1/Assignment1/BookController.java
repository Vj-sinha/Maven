package com.example.Assignmnet1.Assignment1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController 
{
	@Autowired
	Environment env;
	
	@Autowired
	BookRepository repository;
	
	@GetMapping("/getPort")
	public String getPort()
	{
		String port=env.getProperty("local.server.port");
		return port;
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public List<Book> getBooks()
	{
		return repository.findAll();
	}
	
	@PostMapping("/insertBook")
	public void insertBook(@RequestBody Book book)
	{
		Date date=new Date();
		book.setPublishedDate(date);
		repository.save(book);
	}
	
	@DeleteMapping("/delete1000")
	public void deleteBook1000()
	{
		repository.deleteByCosts();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateName()
	{
		String new_name="William";
		repository.updateByAuthorNames(new_name);
	}
	

}
