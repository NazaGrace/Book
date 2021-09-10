package com.example.bookkeeping.service;

import com.example.bookkeeping.dto.BookDTO;
import com.example.bookkeeping.model.Book;
import org.springframework.stereotype.Service;
import com.example.bookkeeping.repositories.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Create
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        System.out.println("book"+book);
        return bookRepository.save(book);
    }

    //Retrieve
    public List<Book> viewBooks() {
        return bookRepository.findAll();
    }

    //Update
    public Book updateBook(long id, BookDTO bookDTO) {
        Book book = bookRepository.getById(id);
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        return bookRepository.save(book);
    }

    //Delete
    public Map<String, Object> deleteBook(long id) {
        Book book = bookRepository.getById(id);
        bookRepository.delete(book);
        Map<String, Object> response = new HashMap<>();
        response.put("code", "00");
        response.put("message", "book deleted successfully");

        return response;
    }
}

    //C - Create
    //R - Retrieve
    //U - Update
    //D - Delete

