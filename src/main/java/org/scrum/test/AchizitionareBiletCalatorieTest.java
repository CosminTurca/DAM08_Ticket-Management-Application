package org.scrum.test;

import org.scrum.domain.project.*;

public class AchizitionareBiletCalatorieTest {

    public static void main(String[] args) {
        Pasager pasager = new Pasager(1, "Ion Popescu", "ion.popescu@example.com", "0712345678");
        System.out.println("Pasager creat: " + pasager.getNume());
        ProgramRuta programRuta = new ProgramRuta(1, "08:00", "10:00");
        System.out.println("Program de rută creat: " + programRuta.getOraPlecare() + " - " + programRuta.getOraSosire());
        Ruta ruta = new Ruta(1, "București", "Constanța", programRuta);
        System.out.println("Rută creată: " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());
        Sofer sofer = new Sofer(1, "Vasile Ionescu", "B123456");
        System.out.println("Șofer creat: " + sofer.getNume());
        Vehicul vehicul = new Vehicul(1, "B-123-XYZ", 50, sofer);
        System.out.println("Vehicul creat: " + vehicul.getNumarInmatriculare() + " condus de " + vehicul.getSofer().getNume());
        ruta.adaugaVehicul(vehicul);
        System.out.println("Vehicul adăugat pe ruta: " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());
        Plata plata = new Plata(1, 50.0, "card", true);
        System.out.println("Plată creată pentru suma de: " + plata.getSuma());
        BookingSystemService bookingSystemService = new BookingSystemService();
        bookingSystemService.adaugaPasager(pasager);
        bookingSystemService.adaugaRuta(ruta);
        bookingSystemService.adaugaVehicul(vehicul);
        Tichet tichet = bookingSystemService.rezervaTichet(pasager, ruta, plata, vehicul, "A1");
        if (tichet != null && tichet.getPlata().getStatusPlata()) {
            System.out.println("Bilet rezervat cu succes pentru pasagerul " + pasager.getNume() +
                    " pe ruta " + ruta.getPunctPlecare() + " -> " + ruta.getPunctSosire());
        } else {
            System.out.println("Eroare la rezervarea biletului!");
        }
    }
}