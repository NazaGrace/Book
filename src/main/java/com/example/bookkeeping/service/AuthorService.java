package com.example.bookkeeping.service;


import com.example.bookkeeping.dto.AuthorDTO;
import com.example.bookkeeping.model.Author;
import com.example.bookkeeping.model.Book;
import com.example.bookkeeping.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    //Create
    public Author addAuthor(AuthorDTO authorDTO){
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setAddress(authorDTO.getAddress());
        author.setSex(authorDTO.getSex());
        author.setAge(authorDTO.getAge());
        System.out.println("author"+author);
        return authorRepository.save(author);
    }

    //Retrieve
    public List<Author> viewAuthors(){
        return authorRepository.findAll();
    }

    //Update
    public Author updateAuthor(long id, AuthorDTO authorDTO){
        Author author = authorRepository.getById(id);
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setAddress(authorDTO.getAddress());
        author.setSex(authorDTO.getAddress());
        author.setAge(authorDTO.getAge());
        return authorRepository.save(author);
    }

    //Delete
    public Map<String, Object> deleteAuthor(long id){
        Author author = authorRepository.getById(id);
        authorRepository.delete(author);
        Map<String, Object> response = new HashMap<>();
        response.put("code", "00");
        response.put("message", "author deleted successfully");

        return response;
    }

}
