package com.user.model;

import com.user.controller.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class User {
    private String idUser;
    private String name;
    private String lastname;
    private String identification;
    private Date birthDate;
    private String email;

    public User(String name, String lastname, String identification, Date birthDate, String email) {
        this.idUser = UUID.randomUUID().toString();
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.birthDate = birthDate;
        this.email = email;
    }

    public User(UserDto userDto) {
        this(userDto.getName(),userDto.getLastname(), userDto.getIdentification(), userDto.getBirthDate(),userDto.getEmail());
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
