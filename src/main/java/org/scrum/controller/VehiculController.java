package org.scrum.controller;

import org.scrum.domain.project.Vehicul;
import org.scrum.services.VehiculService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicule")
public class VehiculController {
    private final VehiculService vehiculService;
    @Autowired
    public VehiculController(VehiculService vehiculService) {
        this.vehiculService = vehiculService;
    }
    @GetMapping
    public List<Vehicul> getAllVehicule() {
        return vehiculService.getAllVehicule();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicul> getVehiculById(@PathVariable Integer id) {
        Optional<Vehicul> vehicul = vehiculService.getVehiculById(id);
        return vehicul.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Vehicul addVehicul(@RequestBody Vehicul vehicul) {
        return vehiculService.addVehicul(vehicul);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vehicul> updateVehicul(@PathVariable Integer id, @RequestBody Vehicul updatedVehicul) {
        try {
            Vehicul vehicul = vehiculService.updateVehicul(id, updatedVehicul);
            return ResponseEntity.ok(vehicul);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicul(@PathVariable Integer id) {
        try {
            vehiculService.deleteVehicul(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/numar/{numarInmatriculare}")
    public ResponseEntity<Vehicul> findByNumarInmatriculare(@PathVariable String numarInmatriculare) {
        Optional<Vehicul> vehicul = vehiculService.findByNumarInmatriculare(numarInmatriculare);
        return vehicul.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/sofer/{soferId}")
    public List<Vehicul> findBySofer(@PathVariable Integer soferId) {
        return vehiculService.findBySofer(soferId);
    }
    @GetMapping("/capacitate/{capacitateMin}/{capacitateMax}")
    public List<Vehicul> findByCapacitateBetween(@PathVariable int capacitateMin, @PathVariable int capacitateMax) {
        return vehiculService.findByCapacitateBetween(capacitateMin, capacitateMax);
    }
}