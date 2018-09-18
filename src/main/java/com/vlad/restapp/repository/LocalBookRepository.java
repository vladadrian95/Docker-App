package com.vlad.restapp.repository;

import com.vlad.restapp.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class LocalBookRepository implements BookRepository {

    private Map<Integer, Book> books;
    private int id = 0;

    public LocalBookRepository() {

        super();
        books = new TreeMap<>();

        Book book1 = new Book();
        book1.setId(++id);
        book1.setTitle("Game of Thrones");
        book1.setAuthor("George R.R. Martin");

        Book book2 = new Book();
        book2.setId(++id);
        book2.setTitle("Foundation");
        book2.setAuthor("Isac Asimov");

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);

    }

    @Override
    public void add(Book book) {

        book.setId(++id);
        if (!books.containsKey(book.getId()))
            books.put(book.getId(), book);

    }

    @Override
    public Book get(int id) {

        return books.get(id);

    }

    @Override
    public void update(Book book) {

        if (!books.containsKey(book.getId()))
            add(book);
        else {
            books.replace(book.getId(), book);
        }

    }

    @Override
    public void delete(int id) {

        if (books.containsKey(id))
            books.remove(id);

    }

    @Override
    public List<Book> getAll() {

        List<Book> allBooks = new ArrayList<>(books.values());
        return allBooks;

    }

}
