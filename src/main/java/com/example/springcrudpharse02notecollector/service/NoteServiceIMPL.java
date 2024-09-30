package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dao.NoteDAO;
import com.example.springcrudpharse02notecollector.dto.NoteDTO;
import com.example.springcrudpharse02notecollector.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//meka service vlasse walata wisheshyen hadapu ekka.internally service walata galapena function meke implement karala tiyenawa.
@Service
public class NoteServiceIMPL implements NoteService{
    @Autowired
    Mapping mapping;

    @Autowired
    NoteDAO noteDAO;

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        return mapping.toNoteDTO(noteDAO.save(mapping.toNoteEntity(noteDTO)));
    }

    @Override
    public List<NoteDTO> getAllNote() {
        return null;
    }

    @Override
    public boolean deleteNote(String id) {
        return false;
    }

    @Override
    public boolean updateNote(String id, NoteDTO noteDTO) {
        return false;
    }
}
