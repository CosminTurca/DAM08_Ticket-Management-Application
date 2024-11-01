package org.oop.app.domain;

public class Plata {
    private int plataId;
    private double suma;
    private String metodaPlata; // Ex: "card", "numerar"
    private boolean statusPlata; // True dacă plata a fost efectuată cu succes

    // Constructor
    public Plata(int plataId, double suma, String metodaPlata, boolean statusPlata) {
        this.plataId = plataId;
        this.suma = suma;
        this.metodaPlata = metodaPlata;
        this.statusPlata = statusPlata;
    }

    public int getPlataId() {
        return plataId;
    }

    public void setPlataId(int plataId) {
        this.plataId = plataId;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(String metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public boolean isStatusPlata() {
        return statusPlata;
    }

    public void setStatusPlata(boolean statusPlata) {
        this.statusPlata = statusPlata;
    }
}

