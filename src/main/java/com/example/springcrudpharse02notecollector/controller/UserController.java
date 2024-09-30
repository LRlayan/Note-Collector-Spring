package com.example.springcrudpharse02notecollector.controller;

import com.example.springcrudpharse02notecollector.dto.UserDTO;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.service.UserService;
import com.example.springcrudpharse02notecollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    //multi part from data - meken ena request eka enne part kihipayaking. me ena hama req ekkama header ekk ha body ekk teenawa.meka tikk complex req ekk.
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            //req eka part widiyt thmai api genna ganne.
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePicture") MultipartFile profilePicture) {
        //Profile picture -----> Base64
        String base64ProPic = "";
        try {
            byte[] bytesProPic = profilePicture.getBytes();
            base64ProPic = AppUtil.profilePicBase64(bytesProPic);

            //UserId generate
            var userId = AppUtil.generateUserId();

            //Build the project
            var userDTO = new UserDTO();
            userDTO.setUserId(userId);
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setEmail(email);
            userDTO.setPassword(password);
            userDTO.setProfilePicture(base64ProPic);
            userService.saveUser(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            //internal server eka danne anthima catch eke.udin tiyen eka catch ekkatwat awe nttn me catch ekata awoth eka internal server. error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable("userId") String userId, @RequestPart("firstName") String firstName, @RequestPart("lastName") String lastName, @RequestPart("email") String email, @RequestPart("password") String password, @RequestPart("profilePicture") MultipartFile profilePicture) throws IOException {
        var userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setProfilePicture(AppUtil.profilePicBase64(profilePicture.getBytes()));
        userService.updateUser(userId, userDTO);
    }
}
