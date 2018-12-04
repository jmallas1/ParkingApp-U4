package org.jrm.data.ticket;

import org.jrm.util.TimeUtils;

import java.util.Date;

public class DailyParking implements ParkingPricing
{

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
}
