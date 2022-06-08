package com.user.service;

import com.user.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    Optional<User> findByIdUser(Long idUser);
    List<User> findAllUsers();
    User updateUser (User user);
    void deleteUser(Long user);
}
