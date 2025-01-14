package org.scrum.services;

import org.scrum.domain.project.Tichet;
import org.scrum.domain.project.Pasager;
import org.scrum.domain.project.Ruta;
import org.scrum.domain.project.Vehicul;
import org.scrum.domain.repositories.TichetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TichetService {
    private final TichetRepository tichetRepository;
    public TichetService(TichetRepository tichetRepository) {
        this.tichetRepository = tichetRepository;
    }
    public List<Tichet> findAll() {
        return tichetRepository.findAll();
    }
    public Optional<Tichet> findById(Integer id) {
        return tichetRepository.findById(id);
    }
    public Tichet save(Tichet tichet) {
        return tichetRepository.save(tichet);
    }
    public void deleteById(Integer id) {
        tichetRepository.deleteById(id);
    }
    public List<Tichet> findByPasager(Pasager pasager) {
        return tichetRepository.findByPasager(pasager);
    }
    public List<Tichet> findByRuta(Ruta ruta) {
        return tichetRepository.findByRuta(ruta);
    }
    public List<Tichet> findByVehicul(Vehicul vehicul) {
        return tichetRepository.findByVehicul(vehicul);
    }
    public List<Tichet> findReservedTickets() {
        return tichetRepository.findByEsteRezervatTrue();
    }
    public List<Tichet> findUnreservedTickets() {
        return tichetRepository.findByEsteRezervatFalse();
    }
    public List<Tichet> findByRutaAndVehicul(Ruta ruta, Vehicul vehicul) {
        return tichetRepository.findByRutaAndVehicul(ruta, vehicul);
    }
    public List<Tichet> findByPasagerAndReservationStatus(Pasager pasager, Boolean esteRezervat) {
        return tichetRepository.findByPasagerAndEsteRezervat(pasager, esteRezervat);
    }
    public List<Tichet> findByRutaAndLoc(Ruta ruta, String loc) {
        return tichetRepository.findByRutaAndLoc(ruta, loc);
    }
}