package com.user.service;

import com.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User createUser(User user);
    public Optional<User> findByIdUser(String idUser);
    public List<User> findAllUsers();
    public User updateUser (String idUser, User user);
    public String deleteUser(String idUser);
}
