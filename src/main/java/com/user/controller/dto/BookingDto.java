package com.user.controller.dto;

public class BookingDto {
    private String nameBook;
    private String categoryBook;
    private String authorBook;
    private int ageBook;

    public BookingDto(String nameBook, String categoryBook, String authorBook, int ageBook) {
        this.nameBook = nameBook;
        this.categoryBook = categoryBook;
        this.authorBook = authorBook;
        this.ageBook = ageBook;
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
