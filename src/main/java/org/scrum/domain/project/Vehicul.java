package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Vehicul implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer vehiculId;
    @NotNull(message = "Numărul de înmatriculare este obligatoriu!")
    @Size(min = 1, max = 20, message = "Numărul de înmatriculare trebuie să aibă între 1 și 20 de caractere!")
    private String numarInmatriculare;
    @NotNull(message = "Capacitatea vehiculului este obligatorie!")
    private Integer capacitate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sofer_id", nullable = false)
    @JsonBackReference
    @NotNull(message = "Un șofer trebuie asociat vehiculului!")
    private Sofer sofer;
    @ManyToOne
    @JoinColumn(name = "ruta_id")
    @JsonBackReference
    private Ruta ruta;
    public Vehicul(String numarInmatriculare, int capacitate, Sofer sofer) {
        this.numarInmatriculare = numarInmatriculare;
        this.capacitate = capacitate;
        this.sofer = sofer;
    }
    public void setVehiculId(Integer vehiculId) {
        this.vehiculId =vehiculId;
    }
}