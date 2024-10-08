package com.example.springcrudpharse02notecollector.service;

import com.example.springcrudpharse02notecollector.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.springcrudpharse02notecollector.dao.NoteDAO;
import com.example.springcrudpharse02notecollector.dto.NoteStatus;
import com.example.springcrudpharse02notecollector.dto.impl.NoteDTO;
import com.example.springcrudpharse02notecollector.entity.impl.NoteEntity;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.exception.NoteNotFoundException;
import com.example.springcrudpharse02notecollector.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<NoteEntity> getAllNotes = noteDAO.findAll();
        return mapping.noteList(getAllNotes);
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> selectedNote = noteDAO.findById(noteId);
        if (!selectedNote.isPresent()){
            throw new NoteNotFoundException("Note Id with" + noteId + "Not found");
        }else {
            noteDAO.deleteById(noteId);
        }
    }

    @Override
    public void updateNote(String noteId, NoteDTO noteDTO) {
        Optional<NoteEntity> tmpNote = noteDAO.findById(noteId);
        if (tmpNote.isPresent()){
            tmpNote.get().setNoteTitle(noteDTO.getNoteTitle());
            tmpNote.get().setNoteDesc(noteDTO.getNoteDesc());
            tmpNote.get().setCurrentDate(noteDTO.getCurrentDate());
            tmpNote.get().setPriorityLevel(noteDTO.getPriorityLevel());
        }
    }

    @Override
    public NoteStatus getNote(String noteId) {
        if(noteDAO.existsById(noteId)){
            var selectedUser = noteDAO.getReferenceById(noteId);
            return mapping.toNoteDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2,"Selected note not found");
        }
    }
}
