package org.scrum.domain.repositories;

import org.scrum.domain.project.Tichet;
import org.scrum.domain.project.Pasager;
import org.scrum.domain.project.Ruta;
import org.scrum.domain.project.Vehicul;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TichetRepository extends JpaRepository<Tichet, Integer> {
    List<Tichet> findByPasager(Pasager pasager);
    List<Tichet> findByRuta(Ruta ruta);
    List<Tichet> findByVehicul(Vehicul vehicul);
    List<Tichet> findByEsteRezervatTrue();
    List<Tichet> findByEsteRezervatFalse();
    List<Tichet> findByRutaAndVehicul(Ruta ruta, Vehicul vehicul);
    List<Tichet> findByPasagerAndEsteRezervat(Pasager pasager, Boolean esteRezervat);
    List<Tichet> findByRutaAndLoc(Ruta ruta, String loc);
}
