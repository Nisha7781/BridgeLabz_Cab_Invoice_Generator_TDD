package org.example;

public class CabInvoiceService
{
    private static final double CostPerKM = 10;
    private static final int RatePerMin = 1;
    public double calculateFare(double distance, int time)
    {
        return distance * CostPerKM + time * RatePerMin;
    }

}