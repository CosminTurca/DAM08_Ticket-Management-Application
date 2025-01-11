package org.scrum.domain.project;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingSystemService {
    private final List<Tichet> tichete;
    private final List<Ruta> rute;
    private final List<Pasager> pasageri;
    private final List<Vehicul> vehicule;
    private final List<Sofer> soferi;
    public BookingSystemService() {
        this.tichete = new ArrayList<>();
        this.rute = new ArrayList<>();
        this.pasageri = new ArrayList<>();
        this.vehicule = new ArrayList<>();
        this.soferi = new ArrayList<>();
    }
    public void adaugaRuta(Ruta ruta) {
        rute.add(ruta);
    }
    public void adaugaPasager(Pasager pasager) {
        pasageri.add(pasager);
    }
    public void adaugaVehicul(Vehicul vehicul) {
        vehicule.add(vehicul);
    }
    public void adaugaSofer(Sofer sofer) {
        soferi.add(sofer);
    }
    public Tichet rezervaTichet(Pasager pasager, Ruta ruta, Plata plata, Vehicul vehicul, String loc) {
        Tichet tichet = new Tichet(tichete.size() + 1, pasager, ruta, plata,vehicul, loc);
        tichete.add(tichet);
        return tichet;
    }
    public String rezervaLoc(Pasager pasager, Ruta ruta, Vehicul vehicul, Plata plata, String loc) {
        int locuriRezervate = (int) tichete.stream()
                .filter(t -> t.getRuta().equals(ruta) && t.getVehicul().equals(vehicul))
                .count();
        if (locuriRezervate >= vehicul.getCapacitate()) {
            return "Nu mai sunt locuri disponibile";
        } else {
            Tichet tichet = new Tichet(tichete.size() + 1, pasager, ruta, plata, vehicul, loc);
            tichete.add(tichet);
            return "Rezervare efectuată pentru locul " + loc;
        }
    }
    public List<Tichet> getTicheteRezervate() {
        return new ArrayList<>(tichete);
    }
    public List<Ruta> getRuteDisponibile() {
        return new ArrayList<>(rute);
    }
    public List<Vehicul> getVehiculeDisponibile() {
        return new ArrayList<>(vehicule);
    }
    public List<Tichet> getTicheteByPasager(Pasager pasager) {
        return tichete.stream()
                .filter(t -> t.getPasager().equals(pasager))
                .collect(Collectors.toList());
    }
}
