package org.oop.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private int rutaId;
    private String punctPlecare;
    private String punctSosire;
    private ProgramRuta programRuta; // Relație cu ProgramRuta
    private List<Vehicul> vehicule;   // Lista de vehicule care operează pe această rută

    // Constructor
    public Ruta(int rutaId, String punctPlecare, String punctSosire, ProgramRuta programRuta) {
        this.rutaId = rutaId;
        this.punctPlecare = punctPlecare;
        this.punctSosire = punctSosire;
        this.programRuta = programRuta;
        this.vehicule = new ArrayList<>();
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

