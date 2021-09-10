package com.example.bookkeeping.controller;

import com.example.bookkeeping.dto.BookDTO;
import com.example.bookkeeping.model.Book;
import org.springframework.web.bind.annotation.*;
import com.example.bookkeeping.service.BookService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody BookDTO bookDTO){
        return bookService.addBook(bookDTO);
    }

    @GetMapping("/view")
    public List<Book>getAllBooks(){
        return bookService.viewBooks();
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        System.out.println("id"+id);
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }
}

















































































































































































































































































