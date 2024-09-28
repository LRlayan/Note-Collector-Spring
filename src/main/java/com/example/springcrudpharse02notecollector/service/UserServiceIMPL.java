package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dao.UserDAO;
import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;
import com.example.springcrudpharse02notecollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public boolean updateUser(String id, UserDTO userDTO) {
        return false;
    }
}
