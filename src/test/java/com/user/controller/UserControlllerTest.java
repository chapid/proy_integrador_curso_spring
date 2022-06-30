package com.user.controller;

import com.user.controller.dto.UserDto;
import com.user.model.User;
import com.user.pruebas.Datos;
import com.user.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControlllerTest {

    private static final Logger logger = LoggerFactory.getLogger(UserControlllerTest.class);

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IUserService iUserService;

    private User user;

    @Test
    void createUser() throws Exception {
        User user1 = new User("Carlos", "Chapid", "11223344",new Date("10/10/1990"),"chapid@gmail.com");
        when(iUserService.createUser(user1)).thenReturn(Datos.crearUsuarioPrueba().orElseThrow());
        mockMvc.perform(post("/v1/users/").contentType(MediaType.APPLICATION_JSON));


        Mockito.when(iUserService.createUser(user)).thenReturn(user);
        mockMvc.perform(post("/v1/users/"));
        verify(iUserService).createUser(Datos.crearUsuarioPrueba().orElseThrow());
    }

    @Test
    void findAll() throws Exception {

        List<User> list = new ArrayList<User>();
        User user1 = new User("Carlos", "Chapid", "11223344",new Date("10/10/1990"),"chapid@gmail.com");
        User user2 = new User("Carlos 2", "Chapid 2", "11223355",new Date("10/10/1990"),"chapid@gmail.com");
        User user3 = new User("Carlos 3", "Chapid 3", "11223366",new Date("10/10/1990"),"chapid@gmail.com");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        Mockito.when(iUserService.findAllUsers()).thenReturn(list);
        //ResponseEntity<Iterable<User>> httpResponse = controller.findAll();
        //Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        mockMvc.perform(get("/v1/users/"));

        verify(iUserService).findAllUsers();
    }

    @Test
    void findById() throws Exception {
        when(iUserService.findByIdUser(1L)).thenReturn(java.util.Optional.of(Datos.crearUsuarioPrueba().orElseThrow()));
        mockMvc.perform(get("/v1/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(iUserService).findByIdUser(1L);
    }

    @Test
    void updateUser() {
    }

    @Test
    void delete() {
    }
}