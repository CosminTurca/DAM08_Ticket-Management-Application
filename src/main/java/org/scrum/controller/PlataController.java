package org.scrum.controller;

import org.scrum.domain.project.Plata;
import org.scrum.services.PlataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plati")
public class PlataController {
   private final PlataService plataService;
    @Autowired
    public PlataController(PlataService plataService) {
        this.plataService = plataService;
    }
    @GetMapping
    public List<Plata> getAllPlati() {
        return plataService.getAllPlati();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Plata> getPlataById(@PathVariable Integer id) {
        Optional<Plata> plata = plataService.getPlataById(id);
        return plata.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/suma")
    public List<Plata> getPlatiBySuma(@RequestParam Double suma) {
        return plataService.getPlatiBySuma(suma);
    }
    @GetMapping("/metoda/{metodaPlata}")
    public List<Plata> getPlatiByMetodaPlata(@PathVariable String metodaPlata) {
        return plataService.getPlatiByMetodaPlata(metodaPlata);
    }
    @GetMapping("/status/{statusPlata}")
    public List<Plata> getPlatiByStatusPlata(@PathVariable Boolean statusPlata) {
        return plataService.getPlatiByStatusPlata(statusPlata);
    }
    @GetMapping("/suma/greater")
    public List<Plata> getPlatiBySumaGreaterThan(@RequestParam Double suma) {
        return plataService.getPlatiBySumaGreaterThan(suma);
    }
    @PostMapping
    public ResponseEntity<Plata> createPlata(@RequestBody Plata plata) {
        Plata savedPlata = plataService.savePlata(plata);
        return ResponseEntity.ok(savedPlata);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Plata> updatePlata(@PathVariable Integer id, @RequestBody Plata plataDetails) {
        Optional<Plata> existingPlata = plataService.getPlataById(id);
        if (existingPlata.isPresent()) {
            Plata plataToUpdate = existingPlata.get();
            plataToUpdate.setSuma(plataDetails.getSuma());
            plataToUpdate.setMetodaPlata(plataDetails.getMetodaPlata());
            plataToUpdate.setStatusPlata(plataDetails.getStatusPlata());
            Plata updatedPlata = plataService.savePlata(plataToUpdate);
            return ResponseEntity.ok(updatedPlata);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlata(@PathVariable Integer id) {
        if (plataService.getPlataById(id).isPresent()) {
            plataService.deletePlataById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}