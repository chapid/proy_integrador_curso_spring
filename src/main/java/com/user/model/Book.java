package com.user.model;

import com.user.controller.dto.BookDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private Long idBook;

    @Column(name = "name")
    private String nameBook;

    @Column(name = "category")
    private String categoryBook;

    @Column(name = "author")
    private String authorBook;

    @Column(name = "age")
    private int ageBook;

    public Book(String nameBook, String categoryBook, String authorBook, int ageBook, Long idBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.categoryBook = categoryBook;
        this.authorBook = authorBook;
        this.ageBook = ageBook;
    }

    /*public Book(BookDto objBookDto) {
    //    this(objBookDto.getNameBook(), objBookDto.getCategoryBook(), objBookDto.getAuthorBook(), objBookDto.getAgeBook());
    */

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdBook() {
        return idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCategoryBook() {
        return categoryBook;
    }

    public void setCategoryBook(String categoryBook) {
        this.categoryBook = categoryBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public int getAgeBook() {
        return ageBook;
    }

    public void setAgeBook(int ageBook) {
        this.ageBook = ageBook;
    }
}
