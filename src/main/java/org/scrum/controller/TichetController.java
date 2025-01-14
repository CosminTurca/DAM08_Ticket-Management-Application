package org.scrum.controller;

import org.scrum.domain.project.Tichet;
import org.scrum.domain.project.Pasager;
import org.scrum.domain.project.Ruta;
import org.scrum.domain.project.Vehicul;
import org.scrum.services.TichetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tichete")
public class TichetController {
    private final TichetService tichetService;
    public TichetController(TichetService tichetService) {
        this.tichetService = tichetService;
    }
    @GetMapping
    public List<Tichet> getAllTichete() {
        return tichetService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tichet> getTichetById(@PathVariable Integer id) {
        Optional<Tichet> tichet = tichetService.findById(id);
        return tichet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Tichet createTichet(@RequestBody Tichet tichet) {
        return tichetService.save(tichet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTichet(@PathVariable Integer id) {
        if (tichetService.findById(id).isPresent()) {
            tichetService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/pasager/{pasagerId}")
    public List<Tichet> getTicheteByPasager(@PathVariable Pasager pasagerId) {
        return tichetService.findByPasager(pasagerId);
    }
    @GetMapping("/ruta/{rutaId}")
    public List<Tichet> getTicheteByRuta(@PathVariable Ruta rutaId) {
        return tichetService.findByRuta(rutaId);
    }
    @GetMapping("/vehicul/{vehiculId}")
    public List<Tichet> getTicheteByVehicul(@PathVariable Vehicul vehiculId) {
        return tichetService.findByVehicul(vehiculId);
    }
    @GetMapping("/rezervate")
    public List<Tichet> getReservedTickets() {
        return tichetService.findReservedTickets();
    }
    @GetMapping("/nerezervate")
    public List<Tichet> getUnreservedTickets() {
        return tichetService.findUnreservedTickets();
    }
    @GetMapping("/ruta/{rutaId}/vehicul/{vehiculId}")
    public List<Tichet> getTicheteByRutaAndVehicul(@PathVariable Ruta rutaId, @PathVariable Vehicul vehiculId) {
        return tichetService.findByRutaAndVehicul(rutaId, vehiculId);
    }
}