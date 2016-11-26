package com.avvero.book.dao;

import com.avvero.book.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Avvero
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
