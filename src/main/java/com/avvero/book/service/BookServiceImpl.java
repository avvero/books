package com.avvero.book.service;

import com.avvero.book.dao.BookRepository;
import com.avvero.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Avvero
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

    public void delete(Long id){
        bookRepository.delete(id);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

}
