package org.scrum.controller;

import org.scrum.domain.project.ProgramRuta;
import org.scrum.services.ProgramRutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programruta")
public class ProgramRutaController {
    private final ProgramRutaService programRutaService;
    @Autowired
    public ProgramRutaController(ProgramRutaService programRutaService) {
        this.programRutaService = programRutaService;
    }
    @PostMapping
    public ResponseEntity<ProgramRuta> addProgramRuta(@RequestBody ProgramRuta programRuta) {
        ProgramRuta savedProgramRuta = programRutaService.saveProgramRuta(programRuta);
        return new ResponseEntity<>(savedProgramRuta, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProgramRuta>> getAllProgramRuta() {
        List<ProgramRuta> programRutas = programRutaService.getAllProgramRuta();
        return new ResponseEntity<>(programRutas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProgramRuta> getProgramRutaById(@PathVariable Integer id) {
        Optional<ProgramRuta> programRuta = programRutaService.getProgramRutaById(id);
        return programRuta.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramRutaById(@PathVariable Integer id) {
        programRutaService.deleteProgramRutaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}