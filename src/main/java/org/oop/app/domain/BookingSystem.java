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

    // Metodă pentru rezervare
    public String rezervaLoc(Pasager pasager, Ruta ruta, Vehicul vehicul, Plata plata, String loc) {
        int locuriRezervate = (int) tichete.stream().filter(t -> t.getRuta().equals(ruta)).count();

        if (locuriRezervate >= vehicul.getCapacitate()) {
            return "Nu mai sunt locuri disponibile";
        } else {
            Tichet tichet = new Tichet(tichete.size() + 1, pasager, ruta, plata, loc);
            tichete.add(tichet);
            return "Rezervare efectuată pentru locul " + loc;
        }
    }
}

