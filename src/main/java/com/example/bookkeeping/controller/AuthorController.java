package com.example.bookkeeping.controller;

import com.example.bookkeeping.dto.AuthorDTO;
import com.example.bookkeeping.model.Author;
import com.example.bookkeeping.repositories.AuthorRepository;
import com.example.bookkeeping.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;

    }

    @PostMapping("/create")
    public Author createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.addAuthor(authorDTO);
    }

    @GetMapping("/view")
    public List<Author>getAllAuthors(){
        return authorService.viewAuthors();
    }

    @PutMapping("/update/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody AuthorDTO authorDTO){
        System.out.println("id"+id);
        return authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteAuthor(@PathVariable long id){
        System.out.println("id"+id);
        return authorService.deleteAuthor(id);
    }

}
