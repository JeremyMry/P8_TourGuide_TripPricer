package com.tourguide.tripPricer.service;

import com.tourguide.tripPricer.models.Provider;
import com.tourguide.tripPricer.models.User;
import com.tourguide.tripPricer.models.UserReward;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TripPricerService {

    public TripPricerService() {
    }
    public List<Provider> getPrice(String apiKey, User user) {
        List<Provider> providers = new ArrayList();
        HashSet providersUsed = new HashSet();

        for(int i = 0; i < 5; ++i) {
            int multiple = ThreadLocalRandom.current().nextInt(100, 700);
            int cumulativeRewardPoints = user.getUserReward().stream().mapToInt(UserReward::getRewardPoints).sum();
            double childrenDiscount = (double)(user.getUserPreferences().getNumberOfChildren() / 3);
            double price = (double)(multiple * user.getUserPreferences().getNumberOfAdults()) + (double)multiple * childrenDiscount * (double)user.getUserPreferences().getTripDuration() + 0.99D - (double)cumulativeRewardPoints;
            if (price < 0.0D) {
                System.out.println(price);
                price = 0.0D;
            }
            String provider = "";

            do {
                provider = this.getProviderName(apiKey, user.getUserPreferences().getNumberOfAdults());
                System.out.println(provider);
            } while(providersUsed.contains(provider));

            providers.add(new Provider(user.getUserId(), provider, price));
        }
        return providers;
    }

    public String getProviderName(String apiKey, int adults) {
        int multiple = ThreadLocalRandom.current().nextInt(1, 10);
        switch(multiple) {
            case 1:
                return "Holiday Travels";
            case 2:
                return "Enterprize Ventures Limited";
            case 3:
                return "Sunny Days";
            case 4:
                return "FlyAway Trips";
            case 5:
                return "United Partners Vacations";
            case 6:
                return "Dream Trips";
            case 7:
                return "Live Free";
            case 8:
                return "Dancing Waves Cruselines and Partners";
            case 9:
                return "AdventureCo";
            default:
                return "Cure-Your-Blues";
        }
    }
}
