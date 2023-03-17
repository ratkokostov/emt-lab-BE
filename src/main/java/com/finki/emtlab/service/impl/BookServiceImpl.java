package com.finki.emtlab.service.impl;

import com.finki.emtlab.model.Author;
import com.finki.emtlab.model.Book;
import com.finki.emtlab.model.enums.BookCategory;
import com.finki.emtlab.repository.BookRepository;
import com.finki.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, String name, Author author, int availableCopies, BookCategory bookCategory) {

        Book newBook = this.findById(id);
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setAvailableCopies(availableCopies);
        newBook.setBookCategory(bookCategory);
        return bookRepository.save(newBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
