package org.oop.app.domain;

public class Pasager {
    private int pasagerId;
    private String nume;
    private String email;
    private String telefon;

    // Constructor
    public Pasager(int pasagerId, String nume, String email, String telefon) {
        this.pasagerId = pasagerId;
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
    }

    public int getPasagerId() {
        return pasagerId;
    }

    public void setPasagerId(int pasagerId) {
        this.pasagerId = pasagerId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}