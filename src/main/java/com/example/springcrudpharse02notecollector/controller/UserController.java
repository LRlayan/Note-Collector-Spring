package com.example.springcrudpharse02notecollector.controller;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePicture") String profilePicture
    ){
        //Profile picture -----> Base64
        var proPicBase64 = AppUtil.profilePicBase64(profilePicture);

        //UserId generate
        var userId = AppUtil.generateUserId();


        // Todo : Build the project
        var userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setProfilePicture(profilePicture);

        return userDTO;
    }
}
