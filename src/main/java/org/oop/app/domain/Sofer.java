package org.oop.app.domain;

public class Sofer {
    private int soferId;
    private String nume;
    private String permisConducere;

    // Constructor
    public Sofer(int soferId, String nume, String permisConducere) {
        this.soferId = soferId;
        this.nume = nume;
        this.permisConducere = permisConducere;
    }

    public int getSoferId() {
        return soferId;
    }

    public void setSoferId(int soferId) {
        this.soferId = soferId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPermisConducere() {
        return permisConducere;
    }

    public void setPermisConducere(String permisConducere) {
        this.permisConducere = permisConducere;
    }
}
