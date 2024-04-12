package controllers;

import entities.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DegreeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/degrees")
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    @PostMapping
    public ResponseEntity<Void> addDegree(@RequestBody Degree degree) {
        degreeService.addDegree(degree);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDegree(@PathVariable UUID id) {
        degreeService.deleteDegree(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Degree>> getAllDegrees() {
        return ResponseEntity.ok(degreeService.getAllDegrees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable UUID id) {
        Optional<Degree> degree = degreeService.getDegree(id);
        return degree.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Degree>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(degreeService.searchByTitle(title));
    }
}