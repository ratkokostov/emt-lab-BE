package com.finki.emtlab.service.impl;

import com.finki.emtlab.model.Author;
import com.finki.emtlab.model.Book;
import com.finki.emtlab.model.dto.BookDto;
import com.finki.emtlab.model.enums.BookCategory;
import com.finki.emtlab.repository.BookRepository;
import com.finki.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Book> save(String name, Author author, int availableCopies, BookCategory bookCategory) {
        Book book = new Book(name,author,availableCopies,bookCategory);
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        this.bookRepository.deleteBookByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getAuthor(), bookDto.getAvailableCopies(), bookDto.getBookCategory());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Author author, int availableCopies, BookCategory bookCategory) {

        Book newBook = this.findById(id).orElseThrow();
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setAvailableCopies(availableCopies);
        newBook.setBookCategory(bookCategory);
        bookRepository.save(newBook);
        return Optional.of(newBook);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.findById(id).orElseThrow();

        book.setName(bookDto.getName());
        book.setBookCategory(bookDto.getBookCategory());
        book.setAuthor(bookDto.getAuthor());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
