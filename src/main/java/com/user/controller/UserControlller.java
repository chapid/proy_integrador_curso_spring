package com.user.controller;

import com.user.controller.dto.UserDto;
import com.user.model.User;
import com.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserControlller {

    private final IUserService iUserService;
    //estoy haciendo una prueba de mi rama
    public UserControlller(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ApiOperation(value = "Crear usuario", authorizations = { @Authorization(value="JWT") })
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.createUser(new User(userDto)));
    }

    @ApiOperation(value = "Consultar todos los usuarios", authorizations = { @Authorization(value="JWT") })
    @GetMapping("")
    public ResponseEntity<Iterable<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.findAllUsers());
    }
    @ApiOperation(value = "Consultar usuario por ID", authorizations = { @Authorization(value="JWT") })
    @GetMapping("{idUser}")
    public Optional<User> findById(@PathVariable Long idUser){
        return iUserService.findByIdUser(idUser);
    }

    @ApiOperation(value = "Actualizar usuario por ID", authorizations = { @Authorization(value="JWT") })
    @PutMapping("{idUser}")
    public User updateUser(@RequestBody User usuario){
        return iUserService.updateUser(usuario);
    }

    @ApiOperation(value = "Eliminar usuario por ID", authorizations = { @Authorization(value="JWT") })
    @DeleteMapping("{idUser}")
    public void delete(@PathVariable Long idUser){
        iUserService.deleteUser(idUser);
    }
}
