package org.scrum.services;

import org.scrum.domain.project.Sofer;
import org.scrum.domain.project.Vehicul;
import org.scrum.domain.repositories.VehiculRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculService {
    private final VehiculRepository vehiculRepository;
    @Autowired
    public VehiculService(VehiculRepository vehiculRepository) {
        this.vehiculRepository = vehiculRepository;
    }
    public List<Vehicul> getAllVehicule() {
        return vehiculRepository.findAll();
    }
    public Optional<Vehicul> getVehiculById(Integer id) {
        return vehiculRepository.findById(id);
    }
    public Vehicul addVehicul(Vehicul vehicul) {
        return vehiculRepository.save(vehicul);
    }
    public Vehicul updateVehicul(Integer id, Vehicul updatedVehicul) {
        return vehiculRepository.findById(id).map(vehicul -> {
            vehicul.setNumarInmatriculare(updatedVehicul.getNumarInmatriculare());
            vehicul.setCapacitate(updatedVehicul.getCapacitate());
            vehicul.setSofer(updatedVehicul.getSofer());
            vehicul.setRuta(updatedVehicul.getRuta());
            return vehiculRepository.save(vehicul);
        }).orElseThrow(() -> new RuntimeException("Vehicul cu ID " + id + " nu a fost găsit."));
    }
    public void deleteVehicul(Integer id) {
        if (vehiculRepository.existsById(id)) {
            vehiculRepository.deleteById(id);
        } else {
            throw new RuntimeException("Vehicul cu ID " + id + " nu a fost găsit.");
        }
    }
    public Optional<Vehicul> findByNumarInmatriculare(String numarInmatriculare) {
        return vehiculRepository.findByNumarInmatriculare(numarInmatriculare);
    }
    public List<Vehicul> findBySofer(Integer soferId) {
        return vehiculRepository.findBySofer(new Sofer(soferId, null, null));
    }
    public List<Vehicul> findByCapacitateBetween(int capacitateMin, int capacitateMax) {
        return vehiculRepository.findByCapacitateBetween(capacitateMin, capacitateMax);
    }
}