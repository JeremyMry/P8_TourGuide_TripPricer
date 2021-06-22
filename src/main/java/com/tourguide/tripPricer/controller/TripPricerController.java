package com.tourguide.tripPricer.controller;

import com.tourguide.tripPricer.models.Provider;
import com.tourguide.tripPricer.models.User;
import com.tourguide.tripPricer.service.TripPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripPricerController {

    @Autowired
    TripPricerService tripPricerService;

    @GetMapping("/getPrice")
    public List<Provider> getPriceServer(@RequestParam String apiKey, User user) {
        return tripPricerService.getPrice(apiKey, user);
    }
}
