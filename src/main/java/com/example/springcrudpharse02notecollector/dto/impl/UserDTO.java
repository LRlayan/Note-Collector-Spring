package com.example.springcrudpharse02notecollector.dto.impl;

import com.example.springcrudpharse02notecollector.dto.SuperDTO;
import com.example.springcrudpharse02notecollector.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserStatus {
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String profilePicture;
    List<NoteDTO> notes;
}
