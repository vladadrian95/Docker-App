package com.vlad.restapp.service;

import com.vlad.restapp.entity.Book;

import java.util.List;

public interface BookService {

    void add(Book book);
    Book get(int id);
    void update(Book book);
    void delete(int id);
    List<Book> getAll();

}
