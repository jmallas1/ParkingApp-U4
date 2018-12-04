package org.jrm.data.ticket;

import java.util.Date;

public class SpecialEvent implements ParkingPricing
{
    Float ParkingFee;

    public SpecialEvent(Float parkingFee)
    {
        ParkingFee = parkingFee;
    }

    public Float getParkingFee() {
        return ParkingFee;
    }

    @Override
    public Float getFee(Date timeIn, Date timeOut) {
        return ParkingFee;
    }

    @Override
    public String toString() {
        return "SpecialEvent{}";
    }
}
