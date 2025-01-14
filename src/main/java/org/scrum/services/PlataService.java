package org.scrum.services;

import org.scrum.domain.project.Plata;
import org.scrum.domain.repositories.PlataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataService {

  private final PlataRepository plataRepository;
    @Autowired
    public PlataService(PlataRepository plataRepository) {
        this.plataRepository = plataRepository;
    }
    public List<Plata> getAllPlati() {
        return plataRepository.findAll();
    }
    public Optional<Plata> getPlataById(Integer id) {
        return plataRepository.findById(id);
    }
    public List<Plata> getPlatiBySuma(Double suma) {
        return plataRepository.findBySuma(suma);
    }
    public List<Plata> getPlatiByMetodaPlata(String metodaPlata) {
        return plataRepository.findByMetodaPlataIgnoreCase(metodaPlata);
    }
    public List<Plata> getPlatiByStatusPlata(Boolean statusPlata) {
        return plataRepository.findByStatusPlata(statusPlata);
    }
    public List<Plata> getPlatiBySumaGreaterThan(Double suma) {
        return plataRepository.findBySumaGreaterThan(suma);
    }
    public Plata savePlata(Plata plata) {
        return plataRepository.save(plata);
    }
    public void deletePlataById(Integer id) {
        plataRepository.deleteById(id);
    }
}