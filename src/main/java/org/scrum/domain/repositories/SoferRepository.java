package org.scrum.domain.repositories;

import org.scrum.domain.project.Sofer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoferRepository extends JpaRepository<Sofer, Integer> {
    List<Sofer> findByNume(String nume);
    List<Sofer> findByPermisConducere(String permisConducere);
    List<Sofer> findByNumeContaining(String partialName);
    List<Sofer> findByPermisConducereStartingWith(String prefix);
    List<Sofer> findByPermisConducereEndingWith(String suffix);
}