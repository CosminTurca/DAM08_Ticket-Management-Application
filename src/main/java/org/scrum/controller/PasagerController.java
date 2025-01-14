package org.scrum.controller;

import org.scrum.domain.project.Pasager;
import org.scrum.services.PasagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pasageri")
public class PasagerController {
    private final PasagerService pasagerService;
    @Autowired
    public PasagerController(PasagerService pasagerService) {
        this.pasagerService = pasagerService;
    }
    @GetMapping
    public List<Pasager> getAllPasageri() {
        return pasagerService.getAllPasageri();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pasager> getPasagerById(@PathVariable Integer id) {
        Optional<Pasager> pasager = pasagerService.getPasagerById(id);
        return pasager.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nume/{nume}")
    public List<Pasager> findPasageriByNume(@PathVariable String nume) {
        return pasagerService.findPasageriByNume(nume);
    }
    @PostMapping
    public Pasager addPasager(@RequestBody Pasager pasager) {
        return pasagerService.addPasager(pasager);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pasager> updatePasager(@PathVariable Integer id, @RequestBody Pasager updatedPasager) {
        try {
            Pasager pasager = pasagerService.updatePasager(id, updatedPasager);
            return ResponseEntity.ok(pasager);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasager(@PathVariable Integer id) {
        try {
            pasagerService.deletePasager(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}