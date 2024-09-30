package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNote();
    boolean deleteNote(String id);
    boolean updateNote(String id,NoteDTO noteDTO);
}
