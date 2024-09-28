package com.example.springcrudpharse02notecollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
    String noteId;
    String time;
    String desc;
    String currentDate;
    String priorityLevel;
    String username;
}
