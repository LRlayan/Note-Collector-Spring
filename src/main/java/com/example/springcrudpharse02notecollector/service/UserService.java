package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getUser(String id);
    void deleteUser(String id);
    void updateUser(String userId,UserDTO userDTO);
    List<UserDTO> getAllUsers();
}
