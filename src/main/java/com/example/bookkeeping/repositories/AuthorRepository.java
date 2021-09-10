package com.example.bookkeeping.repositories;

import com.example.bookkeeping.model.Author;
import com.example.bookkeeping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByAddress(String address);
    List<Author> findBySex(String sex);
    List<Author> findByAge(String age);

}
