package org.example;

public class InvoiceDetails
{
    private final int totalRides;
    private final double totalFare;
    private final double avgFarePerRide;

    public InvoiceDetails(int totalRides, double totalFare, double avgFarePerRide)
    {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = avgFarePerRide;
    }

    public int getTotalRides()
    {
        return totalRides;
    }

    public double getTotalFare()
    {
        return totalFare;
    }

    public double getAvgFarePerRide()
    {
        return avgFarePerRide;
    }

}
