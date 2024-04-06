package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final AddressRepo addressRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public User createUser(User user) {
        addressRepo.save(user.getAddress());
        return userRepo.save(user);
    }
    public User updateUser(User user) {
        addressRepo.save(user.getAddress());
        return userRepo.save(user);
    }
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }
}
