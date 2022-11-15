package com.example.tpspring.service;

import com.example.tpspring.Repositories.VoitureReppositories;
import com.example.tpspring.entites.Voiture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VoitureService {

    private VoitureReppositories voitureReppositories;
    public Voiture saveVoiture(Voiture voiture){
        return  voitureReppositories.save(voiture);
    }

    public List<Voiture> getAllVoitures(){return (List<Voiture>) voitureReppositories.findAll();}

    public Voiture getVoitureById(int id){

        return voitureReppositories.findById(id).orElseThrow(()->new IllegalArgumentException("Voiture id not found"));



    }

    @PostConstruct
    private void addVoituresToEmptyDB(){
        if(voitureReppositories.count()==00){
            saveVoiture(new Voiture("00TN0001",
                    LocalDate.of(2022,01,03), "GOLF 7"));
            saveVoiture(new Voiture("00TN0002",
                    LocalDate.of(2022,01,04), "POLO 8"));

        }
    }
}
