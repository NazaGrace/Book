package com.example.bookkeeping.repositories;

import com.example.bookkeeping.model.Author;
import com.example.bookkeeping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByIsbn(String isbn);

    boolean countAllByTitle(String title);
}
