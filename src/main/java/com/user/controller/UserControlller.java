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

    @PostMapping("")
    public User createUser(@RequestBody UserDto userDto){
        return iUserService.createUser(new User(userDto));
    }

    @ApiOperation(value = "Consultar todos los usuarios", authorizations = { @Authorization(value="JWT") })
    @GetMapping("")
    public ResponseEntity<Iterable<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.findAllUsers());
    }

    @GetMapping("{idUser}")
    public Optional<User> findById(@PathVariable Long idUser){
        return iUserService.findByIdUser(idUser);
    }

    @PutMapping("{idUser}")
    public User updateUser(@RequestBody User usuario){
        return iUserService.updateUser(usuario);
    }

    @DeleteMapping("{idUser}")
    public void delete(@PathVariable Long idUser){
        iUserService.deleteUser(idUser);
    }
}
