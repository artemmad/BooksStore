package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularService {

    private BookRepository bookRepository;

    @Autowired
    public PopularService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookData() {
        return bookRepository.findAll();
    }
}
