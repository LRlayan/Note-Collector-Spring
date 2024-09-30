package com.example.springcrudpharse02notecollector.controller;

import com.example.springcrudpharse02notecollector.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.springcrudpharse02notecollector.dto.impl.UserDTO;
import com.example.springcrudpharse02notecollector.dto.UserStatus;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.exception.UserNotFoundException;
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
import java.util.regex.Pattern;

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
//        String base64ProPic = "";
        try {
            byte[] bytesProPic = profilePicture.getBytes();
            String base64ProPic = AppUtil.profilePicBase64(bytesProPic);

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
    public UserStatus getSelectedUser(@PathVariable("userId") String userId) {
        String regexUserId = "^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexUserId);
        var matcherUserId = regexPattern.matcher(userId);
        if (!matcherUserId.matches()){
            //meke response eka thawa application ekakata ynawa kiyla hithamu.e nisa apita eka http status code walin handle krnna bh.e nisa apita pluwn custom status code ekk hadala eka return kranna.
            return new SelectedUserAndNoteErrorStatus(1,"User ID not valid!");
        }
        return userService.getUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
        String regexUserId = "^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexUserId);
        var matcherUserId = regexPattern.matcher(userId);
        try {
            if (!matcherUserId.matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   // @ResponseStatus(HttpStatus.NO_CONTENT)
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
