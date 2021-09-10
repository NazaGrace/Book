package com.example.bookkeeping.service;

import com.example.bookkeeping.dto.BookDTO;
import com.example.bookkeeping.model.Book;
import com.example.bookkeeping.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookServiceTest{

    @Autowired
    BookService bookService;

    @MockBean
    BookRepository bookRepository;
    Book book;
    BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("The Great Book");
        book.setIsbn("1234");

        bookDTO = new BookDTO();
        bookDTO.setTitle("The Great Book");
        bookDTO.setIsbn("1234");
    }

    @Test
    void addBook() {
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
        Book book = bookService.addBook(bookDTO);
        assertThat(book.getTitle(), is("The Great Book"));
        assertThat(book.getIsbn(), is("1234"));
    }

    @Test
    void updateBook(){
        Mockito.when(bookRepository.getById(Mockito.anyLong())).thenReturn(book);
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
        Book book = bookService.updateBook(1L, bookDTO);
        assertThat(book.getIsbn(), is("1234"));
    }

  @Test
    void viewBook(){
        Mockito.when(bookRepository.findAll()).thenReturn(List.of(book));
        List<Book> book = bookService.viewBooks();
        assertThat(book.get(0).getIsbn(), is("1234"));
    }

    @Test
    void deleteBook(){
        Mockito.when(bookRepository.getById(Mockito.anyLong())).thenReturn(book);
        bookService.deleteBook(1L);
        Mockito.verify(bookRepository, Mockito.times(1)).delete(Mockito.any());
    }
}