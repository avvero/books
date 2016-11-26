package com.avvero.book.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Avvero
 */
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private Date published;

}
