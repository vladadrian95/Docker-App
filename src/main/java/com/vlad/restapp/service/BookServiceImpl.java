package com.vlad.restapp.service;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository repository;

    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Book book) {

        repository.add(book);

    }

    @Override
    public Book get(int id) {

        return repository.get(id);

    }

    @Override
    public void update(Book book) {

        repository.update(book);

    }

    @Override
    public void delete(int id) {

        repository.delete(id);

    }

    @Override
    public List<Book> getAll() {

        return repository.getAll();

    }

}
