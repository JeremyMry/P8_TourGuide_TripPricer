package com.tourguide.tripPricer.models;

import com.tourguide.tripPricer.service.TripPricerService;

import java.util.List;
import java.util.concurrent.Callable;

public class TripPricerTask implements Callable<List<Provider>> {
    private final String apiKey;
    private final User user;

    public TripPricerTask(String apiKey, User user) {
        this.apiKey = apiKey;
        this.user = user;
    }

    public List<Provider> call() throws Exception {
        return (new TripPricerService()).getPrice(this.apiKey, this.user);
    }
}