package org.example;
import java.util.List;
import java.lang.Math;

public class CabInvoiceService
{
    private static final double CostPerKM = 10;
    private static final int RatePerMin = 1;
    private static final int MinimumFare = 5;
    public double calculateFare(double distance, int time)
    {
        double TotalFare =  distance * CostPerKM + time * RatePerMin;
        return Math.max(TotalFare, MinimumFare);
    }

    public InvoiceDetails calculateFare(List<Ride> rides)
    {
        double TotalFare = 0;
        int TotalRides = rides.size();

        for (Ride ride : rides)
        {
            TotalFare = TotalFare +  calculateFare(ride.getDistance(), ride.getTime());
        }

        double avgFarePerRide = TotalFare / TotalRides;

        return new InvoiceDetails(TotalRides, TotalFare, avgFarePerRide);
    }



}