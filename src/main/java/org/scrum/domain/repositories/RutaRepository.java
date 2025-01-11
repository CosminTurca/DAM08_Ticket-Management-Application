package org.scrum.domain.repositories;

import org.scrum.domain.project.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {
    List<Ruta> findByPunctPlecare(String punctPlecare);
    List<Ruta> findByPunctSosire(String punctSosire);
    List<Ruta> findByPunctPlecareAndPunctSosire(String punctPlecare, String punctSosire);
    List<Ruta> findByVehiculeIsNotEmpty();
    List<Ruta> findByProgramRuta_OraPlecare(String oraPlecare);
    List<Ruta> findByProgramRuta_OraSosire(String oraSosire);
}
