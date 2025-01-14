package org.scrum.services;

import org.scrum.domain.project.Ruta;
import org.scrum.domain.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    private final RutaRepository rutaRepository;

    @Autowired
    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public Ruta createRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Optional<Ruta> getRutaById(int id) {
        return rutaRepository.findById(id);
    }

    public List<Ruta> getAllRute() {
        return rutaRepository.findAll();
    }

    public List<Ruta> getRuteByPunctPlecare(String punctPlecare) {
        return rutaRepository.findByPunctPlecare(punctPlecare);
    }

    public List<Ruta> getRuteByPunctSosire(String punctSosire) {
        return rutaRepository.findByPunctSosire(punctSosire);
    }

    public List<Ruta> getRuteByPunctPlecareAndPunctSosire(String punctPlecare, String punctSosire) {
        return rutaRepository.findByPunctPlecareAndPunctSosire(punctPlecare, punctSosire);
    }

    public List<Ruta> getRuteWithVehicule() {
        return rutaRepository.findByVehiculeIsNotEmpty();
    }

    public List<Ruta> getRuteByOraPlecare(String oraPlecare) {
        return rutaRepository.findByProgramRuta_OraPlecare(oraPlecare);
    }

    public List<Ruta> getRuteByOraSosire(String oraSosire) {
        return rutaRepository.findByProgramRuta_OraSosire(oraSosire);
    }

    public Ruta updateRuta(int id, Ruta updatedRuta) {
        return rutaRepository.findById(id).map(ruta -> {
            ruta.setPunctPlecare(updatedRuta.getPunctPlecare());
            ruta.setPunctSosire(updatedRuta.getPunctSosire());
            ruta.setProgramRuta(updatedRuta.getProgramRuta());
            ruta.setVehicule(updatedRuta.getVehicule());
            return rutaRepository.save(ruta);
        }).orElse(null);
    }

    public boolean deleteRuta(int id) {
        if (rutaRepository.existsById(id)) {
            rutaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

