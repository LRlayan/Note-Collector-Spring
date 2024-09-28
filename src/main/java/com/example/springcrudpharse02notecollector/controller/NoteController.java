package com.example.springcrudpharse02notecollector.controller;

import com.example.springcrudpharse02notecollector.dto.NoteDTO;
import com.example.springcrudpharse02notecollector.service.NoteService;
import com.example.springcrudpharse02notecollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/notes")
//meka api ekak / version eka - version eka maruweddi methna version eka thma maru karanne eka standard ekk / class map path
public class NoteController {
    //2024-sep-14
    //controller eke wade req res handle karana eka ha client ekka interact wena eka.
    @Autowired
    NoteService noteService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)//produce karanawa kiyanne server eka patte idan client(deserialize) consume kiyanne anit patta(serialize)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){//RequestBody eka ganna pluwan me annotation eken //mewa end point
        noteDTO.setNoteId(AppUtil.generateNoteId());
        return noteService.saveNote(noteDTO);
    }

//    @GetMapping //mewa end point
    public NoteDTO getSelectedNote(){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)//mewa end point
    public List<NoteDTO> getAllNote(){
        return noteService.getAllNote();
    }

    @DeleteMapping//mewa end point
    public void deleteNote(String noteId,NoteDTO noteDTO){

    }
}
