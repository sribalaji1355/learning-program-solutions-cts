package com.example.exercise2.service;

import com.example.exercise2.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performLibraryOperation() {
        System.out.println("Inside BookService...");
        bookRepository.displayRepositoryMessage();
    }
}
