package org.example;

public class CabInvoiceService
{
    private static final double CostPerKM = 10;
    private static final int RatePerMin = 1;
    private static final int MinimumFare = 5;
    public double calculateFare(double distance, int time)
    {
        double TotalFare =  distance * CostPerKM + time * RatePerMin;
        if(TotalFare < MinimumFare)
        {
            return MinimumFare;
        }
        else
        {
            return TotalFare;
        }
    }

}