package com.example.ex15.repository;

import com.example.ex15.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("select c from Note c where c.id= ?1")
    Note getById(Long id);
}
