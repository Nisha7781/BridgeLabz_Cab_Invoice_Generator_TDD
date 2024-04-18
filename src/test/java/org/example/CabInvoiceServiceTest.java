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
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(30, invoiceDetails.getTotalFare(), 0.0);
    }

    @Test
    public void givenMultipleRides_returnTotalNumOfRides() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(2, invoiceDetails.getTotalRides(),0.0);
    }

    @Test
    public void givenMultipleRides_returnAvfFarePerRide()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(15, invoiceDetails.getAvgFarePerRide(),0.0);
    }

    @Test
    public void givenUserId_returnInvoiceForUser()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(new RideRepository());
        String userId1 = "user1";
        String userId2 = "user2";

        InvoiceDetails invoiceDetails = cabInvoiceService.getInvoiceForUser(userId1);

        Assert.assertEquals(2, invoiceDetails.getTotalRides());
        Assert.assertEquals(30, invoiceDetails.getTotalFare(), 0.0);
        Assert.assertEquals(15, invoiceDetails.getAvgFarePerRide(), 0.0);

        InvoiceDetails invoiceDetails1 = cabInvoiceService.getInvoiceForUser(userId2);
        Assert.assertEquals(1, invoiceDetails1.getTotalRides());
        Assert.assertEquals(37, invoiceDetails1.getTotalFare(), 0.0);
        Assert.assertEquals(37, invoiceDetails1.getAvgFarePerRide(), 0.0);
    }

}