package com.user.controller.dto;

import java.util.Date;

public class UserDto {
    private String nameUser;
    private String lastname;
    private String identification;
    private Date birthDate;
    private String email;

    public UserDto(String name, String lastname, String identification, Date birthDate, String email) {
        this.nameUser = name;
        this.lastname = lastname;
        this.identification = identification;
        this.birthDate = birthDate;
        this.email = email;
    }

    public UserDto() {
    }

    public String getName() {
        return nameUser;
    }

    public void setName(String name) {
        this.nameUser = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
