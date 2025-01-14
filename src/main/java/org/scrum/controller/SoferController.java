package org.scrum.controller;

import org.scrum.domain.project.Sofer;
import org.scrum.services.SoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/soferi")
public class SoferController {
    private final SoferService soferService;
    @Autowired
    public SoferController(SoferService soferService) {
        this.soferService = soferService;
    }
    @GetMapping
    public Map<String, Object> getAllSoferi() {
        List<Sofer> soferi = soferService.findAll();
        Map<String, Object> embedded = new HashMap<>();
        embedded.put("soferi", soferi);
        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", embedded);
        return response;
    }
    /*
    @GetMapping
    public List<Sofer> getAllSoferi() {
        return soferService.findAll();
    }
    */
    @GetMapping("/id/{id}")
    public ResponseEntity<Sofer> getSoferById(@PathVariable Integer id) {
        Optional<Sofer> sofer = soferService.findById(id);
        return sofer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/nume/{nume}")
    public List<Sofer> getSoferiByNume(@PathVariable String nume) {
        return soferService.findByNume(nume);
    }
    @PostMapping
    public Sofer addSofer(@RequestBody Sofer sofer) {
        return soferService.saveOrUpdate(sofer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Sofer> updateSofer(@PathVariable Integer id, @RequestBody Sofer soferDetails) {
        Optional<Sofer> existingSofer = soferService.findById(id);
        if (existingSofer.isPresent()) {
            Sofer sofer = existingSofer.get();
            sofer.setNume(soferDetails.getNume());
            sofer.setPermisConducere(soferDetails.getPermisConducere());
            return ResponseEntity.ok(soferService.saveOrUpdate(sofer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSofer(@PathVariable Integer id) {
        if (soferService.findById(id).isPresent()) {
            soferService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}