package org.oop.app.teste;

import org.oop.app.domain.*;

public class Rezervare_bilet_ruta {
    public static void main(String[] args) {
        // Creăm un șofer
        Sofer sofer = new Sofer(1, "Ion Popescu", "B123456");

        // Creăm un microbuz cu capacitate de 5 locuri
        Vehicul microbuz = new Vehicul(1, "AB-123-CD", 18, sofer);

        // Creăm un program și o rută
        ProgramRuta programRuta = new ProgramRuta(1, "08:00", "10:00");
        Ruta ruta = new Ruta(1, "Iași", "București", programRuta);

        // Creăm un BookingSystem pentru a gestiona rezervările
        BookingSystem bookingSystem = new BookingSystem();

        // Creăm 6 pasageri pentru a testa capacitatea (mai mult decât locurile disponibile)
        for (int i = 1; i <= 19; i++) {
            Pasager pasager = new Pasager(i, "Pasager " + i, "email" + i + "@exemplu.com", "07xxxxxxxx");

            // Creăm o plată pentru fiecare pasager
            Plata plata = new Plata(i, 100.0, "card", true);

            // Încercăm să rezervăm un loc pentru fiecare pasager
            String rezultat = bookingSystem.rezervaLoc(pasager, ruta, microbuz, plata, "Loc " + i);
            System.out.println(rezultat); // Afișează rezultatul rezervării
        }
    }
}