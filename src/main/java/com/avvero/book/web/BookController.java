package com.avvero.book.web;

import com.avvero.book.domain.Book;
import com.avvero.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Avvero
 */
@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findOne(@PathVariable Long id) {
        return bookService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

}
