package com.example.exercise1.Service;

import com.example.exercise1.Repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("BookService: Adding book...");
        bookRepository.saveBook();
    }
}
