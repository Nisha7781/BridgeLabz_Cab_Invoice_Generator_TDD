package org.example;
import java.util.List;
import java.lang.Math;
public class CabInvoiceService
{
    private final RideRepository rideRepository;
    public CabInvoiceService(RideRepository rideRepository)
    {
        this.rideRepository = rideRepository;
    }

    public CabInvoiceService()
    {

        rideRepository = new RideRepository();
    }
    public double calculateFare(double distance, int time)
    {
        final double CostPerKM = 10;
        final int RatePerMin = 1;
        final int MinimumFare = 5;
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


    public InvoiceDetails getInvoiceForUser(String userId)
    {
        return null;
    }
}