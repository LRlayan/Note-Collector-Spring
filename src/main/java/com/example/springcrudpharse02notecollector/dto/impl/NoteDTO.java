package com.example.springcrudpharse02notecollector.dto.impl;

import com.example.springcrudpharse02notecollector.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String currentDate;
    private String priorityLevel;
    private String userId;
}
