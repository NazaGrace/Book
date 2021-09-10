package com.example.bookkeeping.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String address;

    private String sex;

    private int age;

    @ManyToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> book = new HashSet<>();

    public Author() {
    }

    public Author(long id, Set<Book> book, String firstName, String lastName, String address, String sex, int age) {
        this.id = id;
        this.book = book;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    public long getId(){return id;}
    public void setId(long id) {this.id = id; }

    public Set<Book> getBook() {
        return book;
    }
    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getSex(){return sex;}
    public void setSex(String sex){this.sex = sex;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}
}
