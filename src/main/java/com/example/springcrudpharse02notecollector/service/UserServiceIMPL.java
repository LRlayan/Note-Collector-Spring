package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dao.UserDAO;
import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;
import com.example.springcrudpharse02notecollector.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
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
    public UserDTO getUser(String userId) {
//        return mapping.toUserDTO(userDAO.getReferenceById(mapping.toUserDTO()));
        UserEntity user = userDAO.getReferenceById(userId);
        return mapping.toUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUser = userDAO.findAll();
        return mapping.userList(allUser);
    }
}
