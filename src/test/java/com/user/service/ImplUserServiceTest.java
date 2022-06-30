package com.user.service;

import com.user.model.User;
import com.user.pruebas.Datos;
import com.user.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ImplUserServiceTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private ImplUserService implUserService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setName("Carlos");
        user.setLastname("Mojica");
        user.setIdentification("112233");
        user.setBirthDate(new Date("15/10/21"));
        user.setEmail("chapid9@gmail.com");
    }

    @Test
    void createUser() {
        when(iUserRepository.save(user)).thenReturn(Datos.crearUsuarioPrueba().orElseThrow());
        assertNotNull(implUserService.createUser(user));
        verify(iUserRepository).save(user);
    }

    @Test
    void findByIdUser() {
        when(iUserRepository.findById(3L)).thenReturn(java.util.Optional.of(Datos.crearUsuarioPrueba().orElseThrow()));
        assertNotNull(implUserService.findByIdUser(3L));
        verify(iUserRepository).findById(3L);
    }

    @Test
    void findAllUsers() {
        List<User> list = new ArrayList<User>();
        User user1 = new User("Carlos", "Chapid", "11223344",new Date("10/10/1990"),"chapid@gmail.com");
        User user2 = new User("Carlos 2", "Chapid 2", "11223355",new Date("10/10/1990"),"chapid@gmail.com");
        User user3 = new User("Carlos 3", "Chapid 3", "11223366",new Date("10/10/1990"),"chapid@gmail.com");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        when(iUserRepository.findAll()).thenReturn(list);
        assertNotNull(implUserService.findAllUsers());
        verify(iUserRepository).findAll();
    }

    @Test
    void updateUser() {
        when(iUserRepository.save(user)).thenReturn(Datos.crearUsuarioPrueba().orElseThrow());
        assertNotNull(implUserService.createUser(user));
        verify(iUserRepository).save(user);
    }

    @Test
    void deleteUser() {
        Long P_ID = 1L;
        iUserRepository.deleteById(P_ID);
        verify(iUserRepository).deleteById(P_ID);
    }
}