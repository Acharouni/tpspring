package com.example.tpspring.controller;

import com.example.tpspring.entites.Location;
import com.example.tpspring.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;

    @PostMapping("/locations/register/client/{idClient}/voiture/{idVoiture}")
    @ResponseBody
    public Location registerLocation(@RequestBody Location location,
                                     @PathVariable("idClient") int idClient,
                                     @PathVariable("idVoiture") int idVoiture){
        return locationService.registerLocation(location,idClient,idVoiture);
    }
}