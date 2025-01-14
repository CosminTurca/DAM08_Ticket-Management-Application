package org.scrum.services;

import org.scrum.domain.project.Pasager;
import org.scrum.domain.repositories.PasagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasagerService {
    private final PasagerRepository pasagerRepository;
    @Autowired
    public PasagerService(PasagerRepository pasagerRepository) {
        this.pasagerRepository = pasagerRepository;
    }
    public List<Pasager> getAllPasageri() {
        return pasagerRepository.findAll();
    }
    public Optional<Pasager> getPasagerById(Integer id) {
        return pasagerRepository.findById(id);
    }
    public List<Pasager> findPasageriByNume(String nume) {
        return pasagerRepository.findByNume(nume);
    }
    public Pasager addPasager(Pasager pasager) {
        return pasagerRepository.save(pasager);
    }
    public Pasager updatePasager(Integer id, Pasager updatedPasager) {
        return pasagerRepository.findById(id).map(pasager -> {
            pasager.setNume(updatedPasager.getNume());
            pasager.setEmail(updatedPasager.getEmail());
            pasager.setTelefon(updatedPasager.getTelefon());
            return pasagerRepository.save(pasager);
        }).orElseThrow(() -> new RuntimeException("Pasager cu ID " + id + " nu a fost găsit."));
    }
    public void deletePasager(Integer id) {
        if (pasagerRepository.existsById(id)) {
            pasagerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pasager cu ID " + id + " nu a fost găsit.");
        }
    }
}
