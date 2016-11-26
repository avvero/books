package com.avvero.book.service

import com.avvero.book.App
import com.avvero.book.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Avvero
 */
@ContextConfiguration(classes = [App], loader = SpringApplicationContextLoader)
@ActiveProfiles("test")
class BookServiceTests extends Specification {

    @Autowired
    BookService bookService;

    def cleanup() {
        bookService.deleteAll()
    }

    @Unroll
    def "Book can be saved"(){
        setup:
            def book = new Book(title: title, author: author, published: published)
        when:
            bookService.save(book)
            def savedBook = bookService.findAll().first()
        then:
            savedBook.id != null
            savedBook.title == title
            savedBook.author == author
            savedBook.published == published
        where:
            title = "title"
            author = "author"
            published = new Date()
    }

    @Unroll
    def "Book can be updated"(){
        setup:
            def book = bookService.save(new Book(title: "title", author: "author", published: new Date()))
        when:
            def savedBook = bookService.findOne(book.id)
            savedBook.title = title2
            savedBook.author = author2
            savedBook.published = published2
            bookService.save(savedBook)
            def updatedBook = bookService.findOne(book.id)
        then:
            updatedBook.title == title2
            updatedBook.author == author2
            updatedBook.published == published2
        where:
            title2 = "title2"
            author2 = "author2"
            published2 = new Date()
    }

    @Unroll
    def "Book can be deleted"(){
        setup:
            def book = bookService.save(new Book(title: "title", author: "author", published: new Date()))
        when:
            bookService.delete(book.id)
        then:
            bookService.findAll() == []
    }

}
