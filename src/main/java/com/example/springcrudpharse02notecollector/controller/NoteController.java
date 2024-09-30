package com.example.springcrudpharse02notecollector.controller;

import com.example.springcrudpharse02notecollector.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.springcrudpharse02notecollector.dto.NoteStatus;
import com.example.springcrudpharse02notecollector.dto.impl.NoteDTO;
import com.example.springcrudpharse02notecollector.exception.DataPersistException;
import com.example.springcrudpharse02notecollector.exception.UserNotFoundException;
import com.example.springcrudpharse02notecollector.service.NoteService;
import com.example.springcrudpharse02notecollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/notes")
//meka api ekak / version eka - version eka maruweddi methna version eka thma maru karanne eka standard ekk / class map path
public class NoteController {
    //2024-sep-14
    //controller eke wade req res handle karana eka ha client ekka interact wena eka.
    @Autowired
    NoteService noteService;

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)//produce karanawa kiyanne server eka patte idan client(deserialize) consume kiyanne anit patta(serialize)
//    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){//RequestBody eka ganna pluwan me annotation eken //mewa end point
//        noteDTO.setNoteId(AppUtil.generateNoteId());
//        return noteService.saveNote(noteDTO);
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody NoteDTO noteDTO){
        noteDTO.setNoteId(AppUtil.generateNoteId());
        try{
            noteService.saveNote(noteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping //mewa end point
    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteStatus getSelectedNote(@PathVariable ("noteId") String noteId){
        String regexUserId = "^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexUserId);
        var matcherNoteId = regexPattern.matcher(noteId);
        if (!matcherNoteId.matches()){
            return new SelectedUserAndNoteErrorStatus(1,"Note ID is not valid");
        }
        return noteService.getNote(noteId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)//mewa end point
    public List<NoteDTO> getAllNote(){
        return noteService.getAllNote();
    }

    @DeleteMapping(value = "/{noteId}")//mewa end point
    public ResponseEntity<Void> deleteNote(@PathVariable ("noteId") String noteId){
        String regexUserId = "^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexUserId);
        var matcherNoteId = regexPattern.matcher(noteId);
        try{
            if (!matcherNoteId.matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            noteService.deleteNote(noteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{noteId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId ,@RequestBody NoteDTO noteDTO){
        try{
            noteService.updateNote(noteId,noteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
