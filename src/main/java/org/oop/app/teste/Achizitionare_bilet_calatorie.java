package org.oop.app.teste;

import org.oop.app.domain.*;

public class Achizitionare_bilet_calatorie {

    public static void main(String[] args) {
        // Pasul 1: Creăm un pasager
        Pasager pasager = new Pasager(1, "Ion Popescu", "ion.popescu@example.com", "0712345678");
        System.out.println("Pasager creat: " + pasager.getNume());

        // Pasul 2: Creăm un program de rută
        ProgramRuta programRuta = new ProgramRuta(1, "08:00", "10:00");
        System.out.println("Program de rută creat: " + programRuta.getOraPlecare() + " - " + programRuta.getOraSosire());

        // Pasul 3: Creăm o rută
        Ruta ruta = new Ruta(1, "București", "Constanța", programRuta);
        System.out.println("Rută creată: " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());

        // Pasul 4: Creăm un șofer
        Sofer sofer = new Sofer(1, "Vasile Ionescu", "B123456");
        System.out.println("Șofer creat: " + sofer.getNume());

        // Pasul 5: Creăm un vehicul și îl asociem șoferului
        Vehicul vehicul = new Vehicul(1, "B-123-XYZ", 50, sofer);
        System.out.println("Vehicul creat: " + vehicul.getNumarInmatriculare() + " condus de " + vehicul.getSofer().getNume());

        // Asociem vehiculul rutei
        ruta.adaugaVehicul(vehicul);
        System.out.println("Vehicul adăugat pe ruta: " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());

        // Pasul 6: Creăm o plată pentru bilet
        Plata plata = new Plata(1, 50.0, "card", true);
        System.out.println("Plată creată pentru suma de: " + plata.getSuma());

        // Pasul 7: Creăm un sistem de rezervare
        BookingSystem bookingSystem = new BookingSystem();

        // Adăugăm pasagerul, ruta și vehiculul în sistem
        bookingSystem.adaugaPasager(pasager);
        bookingSystem.adaugaRuta(ruta);
        bookingSystem.adaugaVehicul(vehicul);

        // Pasul 8: Rezervăm un tichet pentru pasager pe ruta specificată
        Tichet tichet = bookingSystem.rezervaTichet(pasager, ruta, plata, "A1");

        if (tichet != null && tichet.getPlata().isStatusPlata()) {
            System.out.println("Bilet rezervat cu succes pentru pasagerul " + pasager.getNume() +
                    " pe ruta " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());
        } else {
            System.out.println("Eroare la rezervarea biletului!");
        }
    }
}

