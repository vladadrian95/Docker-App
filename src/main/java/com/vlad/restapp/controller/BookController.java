package com.vlad.restapp.controller;

import com.vlad.restapp.entity.Book;
import com.vlad.restapp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "Success but no content found")

    }
    )
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getBook(@PathVariable Integer id, Model model) {

        Book book = bookService.get(id);
        if (book == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @ApiOperation(value = "Add a new book", response = ResponseEntity.class)
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity postBook(@RequestBody Book book) {

        bookService.add(book);
        return new ResponseEntity<>("Book entry created successfully", HttpStatus.CREATED);

    }

    @ApiOperation(value = "Update existing book", response = ResponseEntity.class)
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 204, message = "Success but no content found to update")

    }
    )
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity putBook(@PathVariable Integer id, @RequestBody Book book) {

        Book bookNew = bookService.get(id);

        if (bookNew == null)
            return new ResponseEntity<>("No content found to update", HttpStatus.NO_CONTENT);

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
