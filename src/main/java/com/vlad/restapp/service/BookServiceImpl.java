package com.vlad.restapp.service;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository repository;

    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Book book) {

        repository.save(book);

    }

    @Override
    public Book get(long id) {

        Optional<Book> book = repository.findById(id);
        return book.orElse(null);

    }

    @Override
    public void update(Book book) {

        repository.save(book);

    }

    @Override
    public void delete(long id) {

        repository.deleteById(id);

    }

    @Override
    public List<Book> getAll() {

        List<Book> books = new ArrayList<>();
        for (Book book : repository.findAll()) {

            books.add(book);

        }
        return books;

    }

}
