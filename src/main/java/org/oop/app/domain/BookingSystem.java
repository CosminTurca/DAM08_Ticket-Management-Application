package org.oop.app.domain;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Tichet> tichete;
    private List<Ruta> rute;
    private List<Pasager> pasageri;
    private List<Vehicul> vehicule;
    private List<Sofer> soferi;

    // Constructor
    public BookingSystem() {
        this.tichete = new ArrayList<>();
        this.rute = new ArrayList<>();
        this.pasageri = new ArrayList<>();
        this.vehicule = new ArrayList<>();
        this.soferi = new ArrayList<>();
    }

    // Metode pentru adăugare tichet, pasager, vehicul, rută etc.
    public void adaugaRuta(Ruta ruta) {
        rute.add(ruta);
    }

    public void adaugaPasager(Pasager pasager) {
        pasageri.add(pasager);
    }

    public void adaugaVehicul(Vehicul vehicul) {
        vehicule.add(vehicul);
    }

    public Tichet rezervaTichet(Pasager pasager, Ruta ruta, Plata plata, String loc) {
        Tichet tichet = new Tichet(tichete.size() + 1, pasager, ruta, plata, loc);
        tichete.add(tichet);
        return tichet;
    }

    // Alte metode pentru anularea rezervării și gestionarea obiectelor din sistem
}

