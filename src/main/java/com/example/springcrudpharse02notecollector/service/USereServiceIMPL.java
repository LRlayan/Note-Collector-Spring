package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.NoteDTO;
import com.example.springcrudpharse02notecollector.dto.UserDTO;

import java.util.List;

public class USereServiceIMPL implements UserService{
    @Override
    public NoteDTO saveUser(UserDTO userDTO) {
        return null;
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
