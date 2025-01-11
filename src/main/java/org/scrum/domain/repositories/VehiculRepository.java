package org.scrum.domain.repositories;

import org.scrum.domain.project.Sofer;
import org.scrum.domain.project.Vehicul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculRepository extends JpaRepository<Vehicul, Integer> {
    Optional<Vehicul> findByNumarInmatriculare(String numarInmatriculare);
    List<Vehicul> findBySofer(Sofer sofer);
    List<Vehicul> findByCapacitateGreaterThan(int capacitate);
    List<Vehicul> findByCapacitateLessThan(int capacitate);
    List<Vehicul> findBySoferIsNull();
    boolean existsByNumarInmatriculare(String numarInmatriculare);
    Optional<Vehicul> findById(Integer id);
    List<Vehicul> findByCapacitateBetween(int capacitateMin, int capacitateMax);
}
