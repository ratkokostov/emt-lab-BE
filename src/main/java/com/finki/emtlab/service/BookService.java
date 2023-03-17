package com.finki.emtlab.service;

import com.finki.emtlab.model.Author;
import com.finki.emtlab.model.Book;
import com.finki.emtlab.model.enums.BookCategory;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(Book book);

    Book edit(Long id, String name, Author author, int availableCopies, BookCategory bookCategory);

    void deleteById(Long id);

    Book findById(Long id);
}
