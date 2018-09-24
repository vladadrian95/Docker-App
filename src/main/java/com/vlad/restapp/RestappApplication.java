package com.vlad.restapp;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(BookRepository repository) {

		return (args) -> {

			Book book1 = new Book();
			book1.setId(1);
			book1.setTitle("Game of Thrones");
			book1.setAuthor("George R.R. Martin");

			Book book2 = new Book();
			book2.setId(2);
			book2.setTitle("The Foundation");
			book2.setAuthor("Isac Asimov");

			repository.save(book1);
			repository.save(book2);

		};

	}

}
