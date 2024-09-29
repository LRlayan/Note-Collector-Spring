package com.example.springcrudpharse02notecollector.util;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for user mapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,UserEntity.class); //map() -  meken karanne userDto ek UserEntity ekakta convert krnwa
    }

    public UserDTO toUserDTO(UserEntity userentity){
        return modelMapper.map(userentity,UserDTO.class);
    }

    public List<UserDTO> userList(List<UserEntity> userList){
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType()); // type token ek dmme list ekk ganna ona nisa.nttn eka user kenai enne.
    }
}
