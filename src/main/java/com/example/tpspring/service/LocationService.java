package com.example.tpspring.service;

import com.example.tpspring.Repositories.LocationRepository;
import com.example.tpspring.entites.Client;
import com.example.tpspring.entites.Location;
import com.example.tpspring.entites.Voiture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {
    private LocationRepository locationRepository;
    private ClientService clientService;
    private VoitureService voitureService;

    public Location registerLocation(Location location,
                                     int idClient,
                                     int idVoiture){
        Client client = clientService.getClientById(idClient);
        Voiture voiture = voitureService.getVoitureById(idVoiture);
        location.setClient(client);
        location.setVoiture(voiture);
        return locationRepository.save(location);

    }
}