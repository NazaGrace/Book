package com.example.bookkeeping.controller;

import com.example.bookkeeping.dto.AuthorDTO;
import com.example.bookkeeping.service.AuthorService;
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
import com.google.gson.Gson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
 class AuthorControllerTest {
    MockMvc mockMvc;
    @InjectMocks
    AuthorController authorController;
    @Mock
    AuthorService authorService;
    AuthorDTO authorDTO;
    Gson gson;
    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
        gson = new Gson();
        authorDTO = new AuthorDTO();
        authorDTO.setFirstName("Ben");
        authorDTO.setLastName("Lodge");
        authorDTO.setAddress("674,Carlie Drive");
        authorDTO.setSex("Male");
        authorDTO.setAge(24);
    }
    @Test
    void addAuthorTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/author/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(authorDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void viewAuthorsTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/author/view"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateAuthor() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/author/update/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(authorDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteAuthor() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/author/delete/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
