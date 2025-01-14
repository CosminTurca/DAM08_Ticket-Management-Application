package org.scrum.services;

import org.scrum.domain.project.ProgramRuta;
import org.scrum.domain.repositories.ProgramRutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramRutaService {

    private final ProgramRutaRepository programRutaRepository;

    @Autowired
    public ProgramRutaService(ProgramRutaRepository programRutaRepository) {
        this.programRutaRepository = programRutaRepository;
    }

    // Metodă pentru a salva un ProgramRuta
    public ProgramRuta saveProgramRuta(ProgramRuta programRuta) {
        return programRutaRepository.save(programRuta);
    }

    // Metodă pentru a obține toate programele rutei
    public List<ProgramRuta> getAllProgramRuta() {
        return programRutaRepository.findAll();
    }

    // Metodă pentru a găsi un ProgramRuta după ID
    public Optional<ProgramRuta> getProgramRutaById(Integer id) {
        return programRutaRepository.findById(id);
    }

    // Metodă pentru a șterge un ProgramRuta după ID
    public void deleteProgramRutaById(Integer id) {
        programRutaRepository.deleteById(id);
    }
}