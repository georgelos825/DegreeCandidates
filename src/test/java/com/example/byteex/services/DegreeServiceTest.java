package com.example.byteex.services;

import entities.Degree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DegreesRepository;
import services.DegreeService;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DegreeServiceTest {

    @Mock
    private DegreesRepository degreesRepository;

    @InjectMocks
    private DegreeService degreeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addDegree() {
        Degree degree = new Degree();
        degree.setTitle("BSc");

        degreeService.addDegree(degree);

        verify(degreesRepository, times(1)).save(degree);
    }

    @Test
    void deleteDegree() {
        UUID id = UUID.randomUUID();
        degreeService.deleteDegree(id);
        verify(degreesRepository, times(1)).deleteById(id);
    }

    @Test
    void searchByTitle() {
        String title = "BSc";
        when(degreesRepository.findByTitle(title)).thenReturn(Collections.singletonList(new Degree()));

        assertEquals(1, degreeService.searchByTitle(title).size());
        verify(degreesRepository, times(1)).findByTitle(title);
    }

    @Test
    void getAllDegrees() {
        when(degreesRepository.findAll()).thenReturn(Collections.singletonList(new Degree()));

        assertEquals(1, degreeService.getAllDegrees().size());
        verify(degreesRepository, times(1)).findAll();
    }

    @Test
    void getDegree() {
        UUID id = UUID.randomUUID();
        Degree degree = new Degree();
        when(degreesRepository.findById(id)).thenReturn(Optional.of(degree));

        assertEquals(Optional.of(degree), degreeService.getDegree(id));
        verify(degreesRepository, times(1)).findById(id);
    }
}