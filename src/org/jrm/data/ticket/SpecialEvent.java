package org.jrm.data.ticket;

import java.util.Date;

/**
 * Class model for "special event" pricing
 * @author Jared Mallas
 * @version 1.0
 */
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

    /**
     * get fee implementation will charge a flat fee for special events
     * @param timeIn
     * @param timeOut
     * @return Float representation for parking fee
     */
    @Override
    public Float getFee(Date timeIn, Date timeOut) {
        return ParkingFee;
    }

    @Override
    public String toString() {
        return "SpecialEvent{}";
    }
}
