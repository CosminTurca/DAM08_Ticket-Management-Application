package org.oop.app.domain;

public class Tichet {
    private int tichetId;
    private Pasager pasager; // Relație cu Pasager
    private Ruta ruta;       // Relație cu Ruta
    private Plata plata;     // Relație cu Plata
    private String loc;      // Ex: numărul locului
    private boolean esteRezervat;

    // Constructor
    public Tichet(int tichetId, Pasager pasager, Ruta ruta, Plata plata, String loc) {
        this.tichetId = tichetId;
        this.pasager = pasager;
        this.ruta = ruta;
        this.plata = plata;
        this.loc = loc;
        this.esteRezervat = false;
    }

    public int getTichetId() {
        return tichetId;
    }

    public void setTichetId(int tichetId) {
        this.tichetId = tichetId;
    }

    public Pasager getPasager() {
        return pasager;
    }

    public void setPasager(Pasager pasager) {
        this.pasager = pasager;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Plata getPlata() {
        return plata;
    }

    public void setPlata(Plata plata) {
        this.plata = plata;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public boolean isEsteRezervat() {
        return esteRezervat;
    }

    public void setEsteRezervat(boolean esteRezervat) {
        this.esteRezervat = esteRezervat;
    }
}
