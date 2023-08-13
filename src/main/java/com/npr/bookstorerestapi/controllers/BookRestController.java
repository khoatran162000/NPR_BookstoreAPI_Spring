package com.npr.bookstorerestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npr.bookstorerestapi.entities.Book;
import com.npr.bookstorerestapi.repositories.BookRepository;



@RestController
public class BookRestController {
	@Autowired
	BookRepository repository;
	
	//ReadAll
	@RequestMapping(value="/books/", method=RequestMethod.GET)
	private List<Book> getBooks() {
		return repository.findAll();
	}
	
	//readById
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	private Book getBook(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	//insertBook
	@RequestMapping(value="/books/", method=RequestMethod.POST)
	private Book createBook(@RequestBody Book book) {
		return repository.save(book);
	}
	
	//updateBook
	@RequestMapping(value="/books/", method=RequestMethod.PUT)
	private Book updateBook(@RequestBody Book book) {
		return repository.save(book);
	}
	
	//deleteById
	@RequestMapping(value="/books/{id} ", method=RequestMethod.DELETE)
	private void deleteBook(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}