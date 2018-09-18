package com.vlad.restapp.controller;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value="bookstore", description = "Operations for managing the books in a store")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {

        this.bookService = bookService;

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<Book> list(Model model) {

        return bookService.getAll();

    }

    @ApiOperation(value = "Retrieve book based on id", response = Book.class)
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public Book getBook(@PathVariable Integer id, Model model) {

        return bookService.get(id);

    }

    @ApiOperation(value = "Add a new book", response = ResponseEntity.class)
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity postBook(@RequestBody Book book) {

        bookService.add(book);
        return new ResponseEntity<>("Book saved successfully", HttpStatus.OK);

    }

    @ApiOperation(value = "Update existing book", response = ResponseEntity.class)
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity putBook(@PathVariable Integer id, @RequestBody Book book) {

        Book bookNew = bookService.get(id);
        bookNew.setTitle(book.getTitle());
        bookNew.setAuthor(book.getAuthor());
        bookService.update(bookNew);

        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);

    }

    @ApiOperation(value = "Delete a book", response = ResponseEntity.class)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteBook(@PathVariable Integer id) {

        bookService.delete(id);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);

    }

}
