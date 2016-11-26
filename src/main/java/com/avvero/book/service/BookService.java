package com.avvero.book.service;

import com.avvero.book.domain.Book;

/**
 * @author Avvero
 */
public interface BookService {

    Iterable<Book> findAll();

    Book findOne(Long id);

    void delete(Long id);

    Book save(Book book);

    void deleteAll();
}
