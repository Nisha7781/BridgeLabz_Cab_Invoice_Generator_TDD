package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository
{
    Map<String, List<Ride>> userRides = new HashMap<>();

    public RideRepository()
    {
        this.userRides = new HashMap<>();
        getSampleRides();
    }

    private void getSampleRides()
    {
        List<Ride> userRide1 = new ArrayList<>();
        userRide1.add(new Ride(2.0,5));
        userRide1.add(new Ride(0.2,1));
        userRides.put("user1",userRide1);

        List<Ride> userRide2 = new ArrayList<>();
        userRide2.add(new Ride(3.0,7));
        userRides.put("user2",userRide2);
    }

    public List<Ride> getRideForUser(String userId)
    {
        return userRides.getOrDefault(userId,new ArrayList<>());
    }

}