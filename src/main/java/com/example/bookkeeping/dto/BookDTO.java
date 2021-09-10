package com.example.bookkeeping.dto;

import com.example.bookkeeping.model.Author;

import java.util.List;

public class BookDTO {

    private String title;

    private String isbn;

    private List<Author> author;

    public BookDTO() {
    }

    public BookDTO(String title, String isbn, List<Author> author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                '}';
    }
}

