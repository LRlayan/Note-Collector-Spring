package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNote();
    boolean deleteNote(String id);
    boolean updateNote(String id,NoteDTO noteDTO);
}
