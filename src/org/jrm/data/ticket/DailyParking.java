package org.jrm.data.ticket;

import org.jrm.util.TimeUtils;

import java.util.Date;

/**
 * Class model for daily parking behavior
 * @author Jared Mallas
 * @version 1.0
 */
public class DailyParking implements ParkingPricing
{

    /**
     * get fee implementation will determine price of parking based on hours spent
     * between entry and exit
     * @param timeIn
     * @param timeOut
     * @return Float representation of parking fee
     */
    @Override
    public Float getFee(Date timeIn, Date timeOut)
    {
        Float totalCharge;

        Integer hourDif = TimeUtils.getHours(timeIn, timeOut);

        if(hourDif <= 3)
        {
            hourDif = 0;
        }
        else
        {
            hourDif -=3;
        }

        totalCharge = 5f + hourDif.floatValue();

        if (totalCharge > 15f)
        {
            return 15f;
        }
        else
        {
            return totalCharge;
        }
    }

    @Override
    public String toString() {
        return "DailyParking{}";
    }
}
