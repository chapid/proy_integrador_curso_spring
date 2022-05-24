package com.user.service;

import com.user.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ImplUserService implements IUserService {
    private final HashMap<String,User> userHashMap = new HashMap<>();

    @Override
    public User createUser(User user) {
        userHashMap.put(user.getIdUser(),user);
        return  user;
    }

    @Override
    public Optional<User> findByIdUser(String idUser) {
        User user = userHashMap.get(idUser);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(userHashMap.values());
    }

    @Override
    public User updateUser(String idUser, User user) {
        User updateUser = new User(
            user.getName(),
            user.getLastname(),
            user.getIdentification(),
            user.getBirthDate(),
            user.getEmail()
        );
        userHashMap.replace(idUser,updateUser);
        return updateUser;
    }

    @Override
    public String deleteUser(String idUser) {
        userHashMap.remove(idUser);
        return "Usuario eliminado!";
    }
}
