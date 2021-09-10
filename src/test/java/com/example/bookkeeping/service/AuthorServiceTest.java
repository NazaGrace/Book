package com.example.bookkeeping.service;

import com.example.bookkeeping.dto.AuthorDTO;
import com.example.bookkeeping.model.Author;
import com.example.bookkeeping.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuthorServiceTest {

    @Autowired
    AuthorService authorService;

    @MockBean
    AuthorRepository authorRepository;
    Author author;
    AuthorDTO authorDTO;

   @BeforeEach
    void setUp(){
       author = new Author();
       author.setFirstName("Ben");
       author.setLastName("Lodge");
       author.setAddress("674,Carlie Drive");
       author.setSex("Male");
       author.setAge(24);

       authorDTO = new AuthorDTO();
       authorDTO.setFirstName("Ben");
       authorDTO.setLastName("Lodge");
       authorDTO.setAddress("674,Carlie Drive");
       authorDTO.setSex("Male");
       authorDTO.setAge(24);
   }

   @Test
    void addAuthor(){
       Mockito.when(authorRepository.save(Mockito.any())).thenReturn(author);
       Author author = authorService.addAuthor(authorDTO);
       assertThat(author.getAge(), is(24));
   }

   @Test
    void updateAuthor(){
       Mockito.when(authorRepository.getById(Mockito.anyLong())).thenReturn(author);
       Mockito.when(authorRepository.save(Mockito.any())).thenReturn(author);
       Author author = authorService.updateAuthor(1L,authorDTO);
       assertThat(author.getAge(), is(24));
   }

   @Test
    void viewAuthor(){
       Mockito.when(authorRepository.findAll()).thenReturn(List.of(author));
       List<Author> author = authorService.viewAuthors();
       assertThat(author.get(0).getAge(), is(24));
   }

    @Test
    void deleteAuthor(){
        Mockito.when(authorRepository.getById(Mockito.anyLong())).thenReturn(author);
        authorService.deleteAuthor(1L);
        Mockito.verify(authorRepository, Mockito.times(1)).delete(Mockito.any());
    }
}
