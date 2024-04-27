package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CabInvoiceServiceTest
{
    @Test
    public void givenDistanceAndTime_returnTotalFareForNormalRide() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 2.0;
        int time = 5;
        String category = "Normal";
        double fare = cabInvoiceService.calculateFare(distance, time, category);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_returnTotalFareForPremiumRide() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 2.0;
        int time = 5;
        String category = "Premium";
        double fare = cabInvoiceService.calculateFare(distance, time, category);
        Assert.assertEquals(40, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTime_returnMinimumFare()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 0.2;
        int time = 1;
        String category = "Normal";
        String category1 = "Premium";
        double fare = cabInvoiceService.calculateFare(distance,time, category);
        Assert.assertEquals(5, fare, 0.0);
        
        double fare1 = cabInvoiceService.calculateFare(distance,time, category1);
        Assert.assertEquals(20, fare1, 0.0);

    }

    @Test
    public void givenMultipleRides_returnTotalFareForNormalRides() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        String category = "Normal";
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides, category);
        Assert.assertEquals(30, invoiceDetails.getTotalFare(), 0.0);
    }

    @Test
    public void givenMultipleRides_returnTotalFareForPremiumRides() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        String category = "Premium";
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides, category);
        Assert.assertEquals(60, invoiceDetails.getTotalFare(), 0.0);
    }

    @Test
    public void givenMultipleRides_returnTotalNumOfRides() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        String category = "Normal";
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides,category);
        Assert.assertEquals(2, invoiceDetails.getTotalRides(),0.0);
    }

    @Test
    public void givenMultipleRides_returnAvfFarePerRide()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.2, 1));
        String category = "Normal";
        String category1 = "Premium";
        InvoiceDetails invoiceDetails = cabInvoiceService.calculateFare(rides,category);
        Assert.assertEquals(15, invoiceDetails.getAvgFarePerRide(),0.0);

        InvoiceDetails invoiceDetails1 = cabInvoiceService.calculateFare(rides,category1);
        Assert.assertEquals(30, invoiceDetails1.getAvgFarePerRide(),0.0);
    }

    @Test
    public void givenUserId_returnInvoiceForUser()
    {
        CabInvoiceService cabInvoiceService = new CabInvoiceService(new RideRepository());
        String userId1 = "user1";
        String userId2 = "user2";
        String category = "Normal";
        String category1 = "Premium";

        InvoiceDetails invoiceDetails = cabInvoiceService.getInvoiceForUser(userId1, category);

        Assert.assertEquals(2, invoiceDetails.getTotalRides());
        Assert.assertEquals(30, invoiceDetails.getTotalFare(), 0.0);
        Assert.assertEquals(15, invoiceDetails.getAvgFarePerRide(), 0.0);

        InvoiceDetails invoiceDetails1 = cabInvoiceService.getInvoiceForUser(userId2, category1);
        Assert.assertEquals(1, invoiceDetails1.getTotalRides());
        Assert.assertEquals(59, invoiceDetails1.getTotalFare(), 0.0);
        Assert.assertEquals(59, invoiceDetails1.getAvgFarePerRide(), 0.0);
    }

}