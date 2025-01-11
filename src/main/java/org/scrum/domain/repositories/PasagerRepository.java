package org.scrum.domain.repositories;

import org.scrum.domain.project.Pasager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasagerRepository extends JpaRepository<Pasager, Integer> {
    List<Pasager> findByNume(String nume);
    Pasager findByEmail(String email);
    Pasager findByTelefon(String telefon);
    List<Pasager> findByNumeContainingIgnoreCase(String partialName);
}
