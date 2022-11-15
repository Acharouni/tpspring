package com.example.tpspring.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Entity
@Data

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_retour")
    private LocalDate dateRetour;

    @Column(name = "prix_jour")
    private double prixJour;

    @Column(name = "prix")
    @Transient
    private double prix;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    @PostLoad
    private void calculatePrix(){
        long nbJour = ChronoUnit.DAYS.between(dateDebut,dateRetour)+1;
        prix = prixJour * nbJour;
    }
}
