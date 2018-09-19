package com.vlad.restapp.service;

import com.vlad.restapp.entity.Book;

import java.util.List;

public interface BookService {

    void add(Book book);
    Book get(long id);
    void update(Book book);
    void delete(long id);
    List<Book> getAll();

}
