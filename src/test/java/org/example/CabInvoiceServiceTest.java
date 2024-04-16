package org.example;
import org.junit.Assert;
import org.junit.Test;

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
}