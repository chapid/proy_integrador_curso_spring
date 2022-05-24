package com.user.controller;

import com.user.controller.dto.UserDto;
import com.user.model.User;
import com.user.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserControlller {

    private final IUserService iUserService;

    public UserControlller(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("")
    public User createUser(@RequestBody UserDto userDto){
        return iUserService.createUser(new User(userDto));
    }

    @GetMapping("")
    public List<User> findAll(){
        return iUserService.findAllUsers();
    }

    @GetMapping("{idUser}")
    public Optional<User> findById(@PathVariable String idUser){
        return iUserService.findByIdUser(idUser);
    }

    @PutMapping("{idUser}")
    public User updateUser(@PathVariable String idUser, @RequestBody UserDto userDto){
        return iUserService.updateUser(idUser,new User(userDto));
    }

    @DeleteMapping("{idUser}")
    public String delete(@PathVariable String idUser){
        return iUserService.deleteUser(idUser);
    }
}
