package com.example.springcrudpharse02notecollector.entity.impl;

import com.example.springcrudpharse02notecollector.dto.NoteDTO;
import com.example.springcrudpharse02notecollector.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User implements SuperEntity {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true) //ekama value eka dennekta assign kranna bh mehem unama
    private String email;
    private String password;
    private String profilePicture;
    @OneToMany(mappedBy = "user")
    private List<Note> notes;
}
