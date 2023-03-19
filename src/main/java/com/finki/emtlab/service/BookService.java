package com.finki.emtlab.service;

import com.finki.emtlab.model.Author;
import com.finki.emtlab.model.Book;
import com.finki.emtlab.model.dto.BookDto;
import com.finki.emtlab.model.enums.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> save(String name, Author author, int availableCopies, BookCategory bookCategory);
    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Author author, int availableCopies, BookCategory bookCategory);
    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> findById(Long id);
}
