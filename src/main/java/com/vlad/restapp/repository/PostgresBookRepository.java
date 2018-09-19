package com.vlad.restapp.repository;

import com.vlad.restapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface PostgresBookRepository extends CrudRepository<Book, Long> {
}
