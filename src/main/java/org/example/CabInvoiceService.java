package org.example;

import java.util.List;
import java.lang.Math;

public class CabInvoiceService {
    private final RideRepository rideRepository;

    public CabInvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public CabInvoiceService() {
        rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time, String category) {
        double costPerKM;
        double ratePerMin;
        double minimumFare;

        if (category.equalsIgnoreCase("Normal")) {
            costPerKM = 10;
            ratePerMin = 1;
            minimumFare = 5;
        } else if (category.equalsIgnoreCase("Premium")) {
            costPerKM = 15;
            ratePerMin = 2;
            minimumFare = 20;
        } else {
            throw new IllegalArgumentException("Invalid category");
        }

        double totalFare = distance * costPerKM + time * ratePerMin;
        return Math.max(totalFare, minimumFare);
    }

    public InvoiceDetails calculateFare(List<Ride> rides, String category) {
        double totalFare = 0;
        int totalRides = rides.size();

        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), category);
        }

        double avgFarePerRide = totalFare / totalRides;

        return new InvoiceDetails(totalRides, totalFare, avgFarePerRide);
    }

    public InvoiceDetails getInvoiceForUser(String userId, String category) {
        List<Ride> userRides = rideRepository.getRideForUser(userId);
        return calculateFare(userRides, category);
    }
}
