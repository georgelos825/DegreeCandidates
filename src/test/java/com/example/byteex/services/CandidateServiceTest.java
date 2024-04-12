package com.example.byteex.services;

import entities.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import repositories.CandidateRepository;
import services.CandidateService;

class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateService candidateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addCandidate() {
        Candidate candidate = new Candidate();
        candidate.setFirstName("John");
        candidate.setLastName("Doe");

        candidateService.addCandidate(candidate);

        verify(candidateRepository, times(1)).save(candidate);
    }

    @Test
    void removeCandidate() {
        UUID id = UUID.randomUUID();
        candidateService.removeCandidate(id);
        verify(candidateRepository, times(1)).deleteById(id);
    }

    @Test
    void getAllCandidates() {
        when(candidateRepository.findAll()).thenReturn(Collections.singletonList(new Candidate()));

        assertEquals(1, candidateService.getAllCandidates().size());
        verify(candidateRepository, times(1)).findAll();
    }

    @Test
    void searchByDegree() {
        UUID degreeId = UUID.randomUUID();
        when(candidateRepository.findByDegreeId(degreeId)).thenReturn(Collections.singletonList(new Candidate()));

        assertEquals(1, candidateService.searchByDegree(degreeId).size());
        verify(candidateRepository, times(1)).findByDegreeId(degreeId);
    }

    @Test
    void searchByName() {
        String name = "John Doe";
        when(candidateRepository.findByName(name)).thenReturn(Collections.singletonList(new Candidate()));

        assertEquals(1, candidateService.searchByName(name).size());
        verify(candidateRepository, times(1)).findByName(name);
    }

    @Test
    void searchByAccepted() {
        boolean accepted = true;
        when(candidateRepository.findByAccepted(accepted)).thenReturn(Collections.singletonList(new Candidate()));

        assertEquals(1, candidateService.searchByAccepted(accepted).size());
        verify(candidateRepository, times(1)).findByAccepted(accepted);
    }

    @Test
    void getCandidate() {
        UUID id = UUID.randomUUID();
        Candidate candidate = new Candidate();
        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        assertEquals(Optional.of(candidate), candidateService.getCandidate(id));
        verify(candidateRepository, times(1)).findById(id);
    }
}