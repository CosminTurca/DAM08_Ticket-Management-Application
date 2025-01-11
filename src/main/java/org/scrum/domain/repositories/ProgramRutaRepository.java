package org.scrum.domain.repositories;

import org.scrum.domain.project.ProgramRuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRutaRepository extends JpaRepository<ProgramRuta, Integer> {
    List<ProgramRuta> findByOraPlecare(String oraPlecare);
    List<ProgramRuta> findByOraSosire(String oraSosire);
    List<ProgramRuta> findByOraPlecareAndOraSosire(String oraPlecare, String oraSosire);
    List<ProgramRuta> findByOraPlecareLessThan(String oraPlecare);
    List<ProgramRuta> findByOraSosireGreaterThan(String oraSosire);
}
