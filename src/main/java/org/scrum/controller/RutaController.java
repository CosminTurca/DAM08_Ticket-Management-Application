package org.scrum.controller;

import org.scrum.domain.project.Ruta;
import org.scrum.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rute")
public class RutaController {
    private final RutaService rutaService;
    @Autowired
    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }
    @PostMapping
    public ResponseEntity<Ruta> createRuta(@RequestBody Ruta ruta) {
        Ruta createdRuta = rutaService.createRuta(ruta);
        return ResponseEntity.ok(createdRuta);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ruta> getRutaById(@PathVariable int id) {
        return rutaService.getRutaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Ruta>> getAllRute() {
        return ResponseEntity.ok(rutaService.getAllRute());
    }
    @GetMapping("/plecare/{punctPlecare}")
    public ResponseEntity<List<Ruta>> getRuteByPunctPlecare(@PathVariable String punctPlecare) {
        return ResponseEntity.ok(rutaService.getRuteByPunctPlecare(punctPlecare));
    }
    @GetMapping("/sosire/{punctSosire}")
    public ResponseEntity<List<Ruta>> getRuteByPunctSosire(@PathVariable String punctSosire) {
        return ResponseEntity.ok(rutaService.getRuteByPunctSosire(punctSosire));
    }
    @GetMapping("/plecare-sosire")
    public ResponseEntity<List<Ruta>> getRuteByPunctPlecareAndPunctSosire(
            @RequestParam String punctPlecare,
            @RequestParam String punctSosire) {
        return ResponseEntity.ok(rutaService.getRuteByPunctPlecareAndPunctSosire(punctPlecare, punctSosire));
    }
    @GetMapping("/vehicule")
    public ResponseEntity<List<Ruta>> getRuteWithVehicule() {
        return ResponseEntity.ok(rutaService.getRuteWithVehicule());
    }
    @GetMapping("/program/plecare/{oraPlecare}")
    public ResponseEntity<List<Ruta>> getRuteByOraPlecare(@PathVariable String oraPlecare) {
        return ResponseEntity.ok(rutaService.getRuteByOraPlecare(oraPlecare));
    }
    @GetMapping("/program/sosire/{oraSosire}")
    public ResponseEntity<List<Ruta>> getRuteByOraSosire(@PathVariable String oraSosire) {
        return ResponseEntity.ok(rutaService.getRuteByOraSosire(oraSosire));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ruta> updateRuta(@PathVariable int id, @RequestBody Ruta ruta) {
        Ruta updatedRuta = rutaService.updateRuta(id, ruta);
        if (updatedRuta != null) {
            return ResponseEntity.ok(updatedRuta);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable int id) {
        if (rutaService.deleteRuta(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}