package org.scrum.domain.repositories;

import org.scrum.domain.project.Plata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlataRepository extends JpaRepository<Plata, Integer> {
    List<Plata> findBySuma(Double suma);
    List<Plata> findByMetodaPlata(String metodaPlata);
    List<Plata> findByStatusPlata(Boolean statusPlata);
    List<Plata> findBySumaGreaterThan(Double suma);
    List<Plata> findByMetodaPlataIgnoreCase(String metodaPlata);
    List<Plata> findByMetodaPlataAndStatusPlata(String metodaPlata, Boolean statusPlata);
}

