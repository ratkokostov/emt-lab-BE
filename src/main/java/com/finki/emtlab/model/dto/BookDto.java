package com.finki.emtlab.model.dto;

import com.finki.emtlab.model.Author;
import com.finki.emtlab.model.enums.BookCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookDto {
    private String name;

    private Author author;

    private int availableCopies;

    private BookCategory bookCategory;

    public BookDto(){}

    public BookDto(String name, Author author, int availableCopies, BookCategory bookCategory) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
    }
}
