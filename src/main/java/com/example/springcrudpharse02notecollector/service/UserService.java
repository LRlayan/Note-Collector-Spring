package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    boolean deleteUser(String id);
    boolean updateUser(String id,UserDTO userDTO);
}
