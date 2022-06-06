package com.user.service;

import com.user.model.User;
import com.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplUserService implements IUserService {

    private final IUserRepository iUserRepository;

    public ImplUserService(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User createUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public Optional<User> findByIdUser(Long idUser) {
        return iUserRepository.findById(idUser);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) iUserRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        if (user.getIdUser() != null && iUserRepository.existsById(user.getIdUser())){
            return iUserRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {
        iUserRepository.deleteById(idUser);
    }
}
