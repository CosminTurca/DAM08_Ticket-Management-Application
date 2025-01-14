package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rutaId;
    private String punctPlecare;
    private String punctSosire;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_ruta_id")
    private ProgramRuta programRuta;
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Vehicul> vehicule = new ArrayList<>();
    public Ruta() {
    }
    public Ruta(int rutaId, String punctPlecare, String punctSosire, ProgramRuta programRuta) {
        this.rutaId = rutaId;
        this.punctPlecare = punctPlecare;
        this.punctSosire = punctSosire;
        this.programRuta = programRuta;
    }
    public int getRutaId() {
        return rutaId;
    }
    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }
    public String getPunctPlecare() {
        return punctPlecare;
    }
    public void setPunctPlecare(String punctPlecare) {
        this.punctPlecare = punctPlecare;
    }
    public String getPunctSosire() {
        return punctSosire;
    }
    public void setPunctSosire(String punctSosire) {
        this.punctSosire = punctSosire;
    }
    public ProgramRuta getProgramRuta() {
        return programRuta;
    }
    public void setProgramRuta(ProgramRuta programRuta) {
        this.programRuta = programRuta;
    }
    public List<Vehicul> getVehicule() {
        return vehicule;
    }
    public void setVehicule(List<Vehicul> vehicule) {
        this.vehicule = vehicule;
    }
    public void adaugaVehicul(Vehicul vehicul) {
        vehicule.add(vehicul);
    }
}