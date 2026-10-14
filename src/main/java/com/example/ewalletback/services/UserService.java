package com.example.ewalletback.services;

import com.example.ewalletback.models.Users;

import java.util.List;

public interface UserService {

    Users save(Users user);

    Users findById(Long id);

    List<Users> findAll();

    Users update(Long id, Users user);

    void delete(Long id);

}