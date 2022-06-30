package com.user.pruebas;

import com.user.model.User;

import java.util.Date;
import java.util.Optional;

public class Datos {
    public static Optional<User> crearUsuarioPrueba(){
        return Optional.of(new User("Carlos","Mojica","112233",new Date("10/10/2020"),"correo@prueba.com"));
    }
}
