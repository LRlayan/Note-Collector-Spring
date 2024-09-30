package com.example.springcrudpharse02notecollector.customStatusCode;

import com.example.springcrudpharse02notecollector.dto.NoteStatus;
import com.example.springcrudpharse02notecollector.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus , NoteStatus {
    private Integer status;
    private String statusMessage;
}
