package com.finki.emtlab.model;

import com.finki.emtlab.model.enums.BookCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private int availableCopies;

    @Enumerated
    private BookCategory bookCategory;

    public Book(){}
    public Book(String name, Author author, int availableCopies, BookCategory bookCategory) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
    }
}
