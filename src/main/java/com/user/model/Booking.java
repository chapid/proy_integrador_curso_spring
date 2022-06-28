package com.user.model;

import com.user.controller.dto.BookingDto;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //no es necesario cuando tiene el mismo nombre
    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "name")
    private String nameBook;

    @Column(name = "category")
    private String categoryBook;

    @Column(name = "author")
    private String authorBook;

    @Column(name = "age")
    private int ageBook;

    public Booking(){}
    public Booking(String nameBook, String categoryBook, String authorBook, int ageBook) {
        this.nameBook = nameBook;
        this.categoryBook = categoryBook;
        this.authorBook = authorBook;
        this.ageBook = ageBook;
    }

    public Booking(BookingDto objBookingDto) {
        this(objBookingDto.getNameBook(), objBookingDto.getCategoryBook(), objBookingDto.getAuthorBook(), objBookingDto.getAgeBook());
    }

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
