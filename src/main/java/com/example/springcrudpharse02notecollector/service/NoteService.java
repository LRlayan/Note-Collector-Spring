package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.NoteStatus;
import com.example.springcrudpharse02notecollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNote();
    void deleteNote(String id);
    boolean updateNote(String id,NoteDTO noteDTO);
    NoteStatus getNote(String noteId);
}
