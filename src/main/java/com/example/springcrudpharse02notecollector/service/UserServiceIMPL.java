package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.springcrudpharse02notecollector.dao.UserDAO;
import com.example.springcrudpharse02notecollector.dto.impl.UserDTO;
import com.example.springcrudpharse02notecollector.dto.UserStatus;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.exception.UserNotFoundException;
import com.example.springcrudpharse02notecollector.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        // mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
        UserEntity saveUser = userDAO.save(mapping.toUserEntity(userDTO));
        if (saveUser == null){
            throw new DataPersistException("User Not Saved.Please Try Again.");
        }
        //hibernate currpt data save kranne nh.
        //app ekak validation karana than tiyeno front-end eke
        //dao eketh krno
        //controller eketh krnawa.
        //meka service eke karata dao ekata thama adala wenne.meke dao layer eka simplyfy interface ekk witri tiyenne.e nisa mekata auwa me validation ek krnna wenne service eke.
    }

    @Override
    public UserStatus getUser(String userId) {
        //        return mapping.toUserDTO(userDAO.getReferenceById(mapping.toUserDTO()));
        if (userDAO.existsById(userId)){
            UserEntity selectedUser = userDAO.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2,"User with ID "+userId+" not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUser = userDAO.findById(userId);
        if (!selectedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + "not found");
        }else {
            userDAO.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDAO.findById(userId);
        if (tmpUser.isPresent()){
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePicture(userDTO.getProfilePicture());
            //jpa wala update method ekk nh native wala thamai tiyenne update method.
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUser = userDAO.findAll();
        return mapping.userList(allUser);
    }
}
