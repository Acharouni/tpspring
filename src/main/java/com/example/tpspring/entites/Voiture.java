package com.example.tpspring.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(name="serie")
    private String serie;

    @Column(name = "data_mise_enmarche")
    private LocalDate dateMiseEnMarche;

    @Column(name = "modele")
    private String modele;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations= new ArrayList<Location>();

    public Voiture(String serie, LocalDate dateMiseEnMarche, String modele) {
        this.serie = serie;
        this.dateMiseEnMarche = dateMiseEnMarche;
        this.modele = modele;
    }
}
