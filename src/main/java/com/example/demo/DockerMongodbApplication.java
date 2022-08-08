package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DockerMongodbApplication {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@Autowired
	public BookRepository bookRepository;
	
	@PostMapping
	public Book bookSave(@RequestBody Book book) {
		if(book==null) {
			System.out.println("book object is null");
			return null;
		}else {
			System.out.println("book name"+book.getId());
			System.out.println("book name"+book.getName());
			System.out.println("book name"+book.getAuthor());
		}
		return bookRepository.save(book);
	}

	@GetMapping
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DockerMongodbApplication.class, args);
	}

}
