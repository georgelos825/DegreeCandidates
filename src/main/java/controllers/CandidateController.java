package controllers;

import entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CandidateService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<Void> addCandidate(@RequestBody Candidate candidate) {
        candidateService.addCandidate(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCandidate(@PathVariable UUID id) {
        candidateService.removeCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable UUID id) {
        Optional<Candidate> candidate = candidateService.getCandidate(id);
        return candidate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/searchByDegree")
    public ResponseEntity<List<Candidate>> searchByDegree(@RequestParam UUID degreeId) {
        return ResponseEntity.ok(candidateService.searchByDegree(degreeId));
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Candidate>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(candidateService.searchByName(name));
    }

    @GetMapping("/searchByAccepted")
    public ResponseEntity<List<Candidate>> searchByAccepted(@RequestParam boolean accepted) {
        return ResponseEntity.ok(candidateService.searchByAccepted(accepted));
    }
}