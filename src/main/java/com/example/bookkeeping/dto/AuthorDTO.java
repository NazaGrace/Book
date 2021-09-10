package com.example.bookkeeping.dto;

import com.example.bookkeeping.model.Book;

import java.util.List;
import java.util.Set;

public class AuthorDTO {
    private String firstName;

    private String lastName;

    private String address;

    private String sex;

    private int age;

    private List<Book> book;

    public AuthorDTO() {
    }

    public AuthorDTO(String firstName, String lastName, String address, String sex, int age, List<Book> book){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sex = sex;
        this.age = age;
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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", book=" + book +
                '}';
    }
}
