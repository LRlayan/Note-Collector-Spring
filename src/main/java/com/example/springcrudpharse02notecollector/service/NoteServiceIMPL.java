package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.dao.NoteDAO;
import com.example.springcrudpharse02notecollector.dto.impl.NoteDTO;
import com.example.springcrudpharse02notecollector.entity.impl.NoteEntity;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//meka service vlasse walata wisheshyen hadapu ekka.internally service walata galapena function meke implement karala tiyenawa.
@Service
@Transactional
public class NoteServiceIMPL implements NoteService{
    @Autowired
    private Mapping mapping;

    @Autowired
    private NoteDAO noteDAO;

    @Override
    public void saveNote(NoteDTO noteDTO) {
        NoteEntity noteSave = noteDAO.save(mapping.toNoteEntity(noteDTO));
        if (noteSave == null){
            throw new DataPersistException("Note not saved");
        }
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
