package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id) throws ResourceNotFoundException;
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book) throws ResourceNotFoundException;
    void deleteBook(Long id) throws ResourceNotFoundException;
}
