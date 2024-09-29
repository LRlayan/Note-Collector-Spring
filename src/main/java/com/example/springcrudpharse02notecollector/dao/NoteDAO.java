package com.example.springcrudpharse02notecollector.dao;

import com.example.springcrudpharse02notecollector.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<NoteEntity,String> {
}
