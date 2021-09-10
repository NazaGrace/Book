package com.example.bookkeeping.controller;

import com.example.bookkeeping.dto.BookDTO;
import com.example.bookkeeping.service.BookService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookControllerTest {
    MockMvc mockMvc;
    @InjectMocks
    BookController bookController;
    @Mock
    BookService bookService;
    BookDTO bookDTO;
    Gson gson;
    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        gson = new Gson();
        bookDTO = new BookDTO();
        bookDTO.setIsbn("1234");
        bookDTO.setTitle("The Great Book");

    }
    @Test
    void createBookTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/book/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(bookDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void viewBooksTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/book/view"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateBook() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/book/update/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(bookDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteBook() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/book/delete/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}