package org.scrum.test;

import org.scrum.domain.project.*;

public class RezervareBiletRutaTest {
    public static void main(String[] args) {
        Sofer sofer = new Sofer(1, "Ion Popescu", "B123456");
        Vehicul microbuz = new Vehicul(1, "AB-123-CD", 18, sofer);
        ProgramRuta programRuta = new ProgramRuta(1, "08:00", "10:00");
        Ruta ruta = new Ruta(1, "Iași", "București", programRuta);
        BookingSystemService bookingSystemService = new BookingSystemService();
        for (int i = 1; i <= 19; i++) {
            Pasager pasager = new Pasager(i, "Pasager " + i, "email" + i + "@exemplu.com", "07xxxxxxxx");
            Plata plata = new Plata(i, 100.0, "card", true);
            String rezultat = bookingSystemService.rezervaLoc(pasager, ruta, microbuz, plata, "Loc " + i);
            System.out.println(rezultat);
        }
    }
}