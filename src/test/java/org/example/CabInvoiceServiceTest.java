package org.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CabInvoiceServiceTest
{
    @Test
    public void givenDistanceAndTime_returnTotalFare()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTime_returnMinimumFare()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 0.2;
        int time = 1;
        double fare = cabInvoiceService.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_returnTotalFare()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<Ride>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        double TotalFare = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(30, TotalFare, 0.0);
    }
}