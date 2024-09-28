package com.example.springcrudpharse02notecollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements SuperDTO {
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String profilePicture;
    List<NoteDTO> notes;
}
