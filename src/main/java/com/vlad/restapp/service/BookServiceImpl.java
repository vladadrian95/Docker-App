package com.vlad.restapp.service;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.repository.BookRepository;
import com.vlad.restapp.repository.PostgresBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private PostgresBookRepository repository;

    @Autowired
    public void setRepository(PostgresBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Book book) {

        repository.save(book);

    }

    @Override
    public Book get(long id) {

        return repository.findById(id).get();

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
