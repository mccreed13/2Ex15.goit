package com.example.ex15.service;

import com.example.ex15.entity.Note;
import com.example.ex15.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;
    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @InjectMocks
    private NoteService noteService;

    @Test
    void add() {
        //Given
        Note note = createTestNote();
        //When
        Mockito.when(noteService.add(note)).thenReturn(note);
        //Then
        Assertions.assertEquals(note.getId(), 1L);
    }

    private Note createTestNote() {
        Note note = new Note();
        note.setId(1L);
        note.setContent("contenttest");
        note.setTitle("titletest");
        return note;
    }

    @Test
    void getById() {
        //Given
        Note note = createTestNote();
        Note note1 = createTestNote();
        //When
        Mockito.when(noteService.getById(1L)).thenReturn(note);
        Mockito.when(noteService.getById(note.getId())).thenReturn(note1);
        //Then
        Assertions.assertEquals(note, note1);
    }
}