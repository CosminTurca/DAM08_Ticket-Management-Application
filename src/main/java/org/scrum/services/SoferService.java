package org.scrum.services;

import org.scrum.domain.project.Sofer;
import org.scrum.domain.repositories.SoferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoferService {
    private final SoferRepository soferRepository;
    @Autowired
    public SoferService(SoferRepository soferRepository) {
        this.soferRepository = soferRepository;
    }
    public List<Sofer> findAll() {
        return soferRepository.findAll();
    }
    public Optional<Sofer> findById(Integer id) {
        return soferRepository.findById(id);
    }
    public List<Sofer> findByNume(String nume) {
        return soferRepository.findByNume(nume);
    }
    public Sofer saveOrUpdate(Sofer sofer) {
        return soferRepository.save(sofer);
    }
    public void deleteById(Integer id) {
        soferRepository.deleteById(id);
    }
}