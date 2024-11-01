package org.oop.app.domain;

public class Vehicul {
    private int vehiculId;
    private String numarInmatriculare;
    private int capacitate;
    private Sofer sofer; // Relație cu Sofer

    // Constructor
    public Vehicul(int vehiculId, String numarInmatriculare, int capacitate, Sofer sofer) {
        this.vehiculId = vehiculId;
        this.numarInmatriculare = numarInmatriculare;
        this.capacitate = capacitate;
        this.sofer = sofer;
    }

    public int getVehiculId() {
        return vehiculId;
    }

    public void setVehiculId(int vehiculId) {
        this.vehiculId = vehiculId;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer) {
        this.sofer = sofer;
    }
}

