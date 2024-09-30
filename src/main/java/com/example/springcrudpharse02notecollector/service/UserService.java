package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.dto.UserStatus;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    UserStatus getUser(String id);
    void deleteUser(String id);
    void updateUser(String userId,UserDTO userDTO);
    List<UserDTO> getAllUsers();
}
